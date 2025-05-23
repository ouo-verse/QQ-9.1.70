package com.tencent.vas.update.request;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.vas.update.callback.listener.IBusinessCallback;
import com.tencent.vas.update.entity.BusinessItemInfo;
import com.tencent.vas.update.entity.BusinessUpdateParams;
import com.tencent.vas.update.entity.Constants;
import com.tencent.vas.update.entity.db.ItemLocalVerPrt;
import com.tencent.vas.update.entity.db.ItemUpdateVerPtr;
import com.tencent.vas.update.entity.db.Preload;
import com.tencent.vas.update.entity.db.PreloadItem;
import com.tencent.vas.update.entity.db.SeqConfigEntity;
import com.tencent.vas.update.entity.db.SyncItemRecord;
import com.tencent.vas.update.util.CommonUtil;
import com.tencent.vas.update.wrapper.VasUpdateWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sw4.c;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TaskSyncReq {
    private static final int MAX_READ_SIZE = 1300;
    private static final String TAG = "VasUpdate_TaskSyncReq";
    private HashMap<String, ItemLocalVerPrt> mArrayExistItem = new HashMap<>();
    private int mDLFrom;
    private SeqConfigEntity mSeqConfig;
    private int mSyncMode;

    public TaskSyncReq(int i3) {
        this.mDLFrom = i3;
    }

    private void addLocalShouldUpdate(HashMap<String, ItemUpdateVerPtr> hashMap) {
        List<c.a> a16 = VasUpdateWrapper.getDbManager().a(1);
        if (a16 != null && a16.size() > 0) {
            VasUpdateWrapper.getLog().d(TAG, "getShouldUpdateList add table_should_update size = " + a16.size());
            for (c.a aVar : a16) {
                if (aVar != null) {
                    ItemUpdateVerPtr parseJsonToItemUpdateVerPrt = ItemUpdateVerPtr.parseJsonToItemUpdateVerPrt(aVar.f434915b);
                    if (parseJsonToItemUpdateVerPrt != null && !TextUtils.isEmpty(parseJsonToItemUpdateVerPrt.mItemId)) {
                        if (!parseJsonToItemUpdateVerPrt.checkItemIsCurrentVersion()) {
                            VasUpdateWrapper.getLog().e(TAG, "seq addLocalShouldUpdate item continue , version not fit");
                        } else {
                            parseJsonToItemUpdateVerPrt.mFrom = Constants.UpdateFrom.SILENT_UPDATE;
                            hashMap.put(parseJsonToItemUpdateVerPrt.mItemId, parseJsonToItemUpdateVerPrt);
                        }
                    } else {
                        VasUpdateWrapper.getLog().e(TAG, "addLocalShouldUpdate item = null or itemId = null ");
                    }
                }
            }
        }
    }

    private void addPreloadItem(HashMap<String, ItemUpdateVerPtr> hashMap, int i3, ArrayList<PreloadItem> arrayList) {
        Iterator<PreloadItem> it = arrayList.iterator();
        while (it.hasNext()) {
            PreloadItem next = it.next();
            if (next != null) {
                if (!hashMap.containsKey(next.mItemId) && !TextUtils.isEmpty(next.mItemId)) {
                    if (!isNetWorkValid(i3, next.mFlag)) {
                        VasUpdateWrapper.getLog().e(TAG, "addPreloadItem network invalid , localNetType = " + i3 + " , mFlag = " + next.mFlag + " , itemId = " + next.mItemId);
                    } else {
                        ItemUpdateVerPtr itemUpdateVerPtr = new ItemUpdateVerPtr();
                        String str = next.mItemId;
                        itemUpdateVerPtr.mItemId = str;
                        itemUpdateVerPtr.mSrcMd5 = "";
                        itemUpdateVerPtr.mDstMd5 = "";
                        itemUpdateVerPtr.mFrom = Constants.UpdateFrom.SILENT_UPDATE;
                        itemUpdateVerPtr.mLastRunTime = 0L;
                        itemUpdateVerPtr.mRunCount = 0;
                        hashMap.put(str, itemUpdateVerPtr);
                        VasUpdateWrapper.getDbManager().d(1, itemUpdateVerPtr.mItemId, ItemUpdateVerPtr.convertItemUpdateVerPrtToJson(itemUpdateVerPtr));
                        VasUpdateWrapper.getLog().i(TAG, "getShouldUpdateList preload item add , id = " + itemUpdateVerPtr.mItemId);
                    }
                } else {
                    VasUpdateWrapper.getLog().e(TAG, "addPreloadItem itemId = null , currentId = " + next.mItemId);
                }
            }
        }
    }

    private void addSyncItemUpdate(HashMap<String, ItemUpdateVerPtr> hashMap, ArrayList<SyncItemRecord> arrayList) {
        ItemLocalVerPrt itemLocalVerPrt;
        StringBuilder sb5 = new StringBuilder();
        Iterator<SyncItemRecord> it = arrayList.iterator();
        boolean z16 = false;
        while (it.hasNext()) {
            SyncItemRecord next = it.next();
            if (next != null) {
                long sParseBidId = CommonUtil.sParseBidId(next.mItemId);
                String sParseScid = CommonUtil.sParseScid(next.mItemId);
                IBusinessCallback a16 = VasUpdateWrapper.getVasUpdateSystem().a(sParseBidId);
                if (a16 == null) {
                    VasUpdateWrapper.getLog().e(TAG, "getShouldUpdateList currentItem not register , itemId = " + next.mItemId);
                    VasUpdateWrapper.getDbManager().c(1, next.mItemId);
                } else {
                    BusinessItemInfo businessItemInfo = a16.getBusinessItemInfo(sParseBidId, sParseScid);
                    if (businessItemInfo == null) {
                        VasUpdateWrapper.getLog().e(TAG, "getShouldUpdateList getItemInfo fail , itemId = " + next.mItemId);
                        VasUpdateWrapper.getDbManager().c(1, next.mItemId);
                    } else {
                        BusinessUpdateParams businessUpdateParams = new BusinessUpdateParams(sParseBidId, sParseScid, Constants.UpdateFrom.SILENT_UPDATE);
                        if (next.mType == 2) {
                            VasUpdateWrapper.getDbManager().c(0, next.mItemId);
                            VasUpdateWrapper.getDbManager().c(1, next.mItemId);
                            hashMap.remove(next.mItemId);
                            a16.deleteFile(businessUpdateParams, businessItemInfo);
                            VasUpdateWrapper.getLog().e(TAG, "getShouldUpdateList item type delete , id = " + next.mItemId);
                        } else {
                            String b16 = VasUpdateWrapper.getDbManager().b(0, next.mItemId);
                            if (!TextUtils.isEmpty(b16)) {
                                itemLocalVerPrt = ItemLocalVerPrt.parseJsonToItemLocalVerPrt(b16);
                            } else {
                                itemLocalVerPrt = null;
                            }
                            ItemLocalVerPrt itemLocalVerPrt2 = itemLocalVerPrt;
                            if (itemLocalVerPrt2 == null) {
                                sb5.append(" , id = ");
                                sb5.append(next.mItemId);
                                z16 = true;
                            } else if (isItemNeedToUpdate(next, a16, businessItemInfo, businessUpdateParams, itemLocalVerPrt2)) {
                                ItemUpdateVerPtr itemUpdateVerPtr = new ItemUpdateVerPtr();
                                String str = next.mItemId;
                                itemUpdateVerPtr.mItemId = str;
                                itemUpdateVerPtr.mSrcMd5 = itemLocalVerPrt2.mMd5;
                                itemUpdateVerPtr.mDstMd5 = next.mMD5;
                                itemUpdateVerPtr.mFrom = Constants.UpdateFrom.SILENT_UPDATE;
                                itemUpdateVerPtr.mLastRunTime = 0L;
                                itemUpdateVerPtr.mRunCount = 0;
                                itemUpdateVerPtr.mAppVersion = next.mAppVersion;
                                hashMap.put(str, itemUpdateVerPtr);
                                VasUpdateWrapper.getDbManager().d(1, itemUpdateVerPtr.mItemId, ItemUpdateVerPtr.convertItemUpdateVerPrtToJson(itemUpdateVerPtr));
                                VasUpdateWrapper.getLog().i(TAG, "getShouldUpdateList local item check need update , id = " + next.mItemId);
                            }
                        }
                    }
                }
            }
        }
        if (z16) {
            VasUpdateWrapper.getLog().e(TAG, "getShouldUpdateList local item doesn't match" + ((Object) sb5));
        }
    }

    private boolean check2G(int i3, int i16) {
        if (5 == i3 && (i16 & 2) == 0) {
            return true;
        }
        return false;
    }

    private boolean check3G(int i3, int i16) {
        if (4 == i3 && (i16 & 4) == 0) {
            return true;
        }
        return false;
    }

    private boolean check4G(int i3, int i16) {
        if (3 == i3 && (i16 & 8) == 0) {
            return true;
        }
        return false;
    }

    private boolean checkWifi(int i3, int i16) {
        if (2 == i3 && (i16 & 1) == 0) {
            return true;
        }
        return false;
    }

    private boolean checkXG(int i3, int i16) {
        if (6 == i3 && (i16 & 14) == 0) {
            return true;
        }
        return false;
    }

    private String getRequestContent() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("seq", this.mSeqConfig.mSeq);
            jSONObject.put("sync_mode", this.mSyncMode);
            jSONObject.put("plver", this.mSeqConfig.mPreloadVer);
            jSONObject.put("item_list", parseItemLocalVerList(this.mArrayExistItem));
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        VasUpdateWrapper.getLog().e(TAG, "sync getRequestContent = " + jSONObject.toString());
        return jSONObject.toString();
    }

    private HashMap<String, ItemUpdateVerPtr> getShouldUpdateList(@NonNull TaskSyncRsp taskSyncRsp) {
        HashMap<String, ItemUpdateVerPtr> hashMap = new HashMap<>();
        VasUpdateWrapper.getLog().d(TAG, "getShouldUpdateList rsp = " + taskSyncRsp.toString());
        try {
            addLocalShouldUpdate(hashMap);
            addSyncItemUpdate(hashMap, taskSyncRsp.mVcrList);
            int netType = VasUpdateWrapper.getCommonManager().getNetType();
            ArrayList<PreloadItem> arrayList = this.mSeqConfig.mPreloadList;
            if (arrayList != null && arrayList.size() > 0) {
                addPreloadItem(hashMap, netType, arrayList);
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
            VasUpdateWrapper.getLog().e(TAG, "getShouldUpdateList exception msg = " + th5.getMessage());
        }
        return hashMap;
    }

    private boolean isItemNeedToUpdate(@NonNull SyncItemRecord syncItemRecord, @NonNull IBusinessCallback iBusinessCallback, @NonNull BusinessItemInfo businessItemInfo, @NonNull BusinessUpdateParams businessUpdateParams, @NonNull ItemLocalVerPrt itemLocalVerPrt) {
        String str = itemLocalVerPrt.mMd5;
        if ((str != null && !str.equalsIgnoreCase(syncItemRecord.mMD5)) || !iBusinessCallback.isFileExist(businessUpdateParams, businessItemInfo)) {
            return true;
        }
        return false;
    }

    private boolean isNetWorkValid(int i3, int i16) {
        if (checkWifi(i3, i16) || check2G(i3, i16) || check3G(i3, i16) || check4G(i3, i16) || checkXG(i3, i16)) {
            return false;
        }
        return true;
    }

    private void notifyComplete(int i3, String str, HashMap<String, ItemUpdateVerPtr> hashMap) {
        VasUpdateWrapper.getLog().d(TAG, "task sync notifyComplete syncErrorCode = " + i3 + " message = " + str);
        VasUpdateWrapper.getVasUpdateSystem().k(this.mSeqConfig.mPollTime, this.mDLFrom, hashMap);
    }

    private JSONArray parseItemLocalVerList(HashMap<String, ItemLocalVerPrt> hashMap) {
        JSONArray jSONArray = new JSONArray();
        if (hashMap == null) {
            return jSONArray;
        }
        try {
            Iterator<Map.Entry<String, ItemLocalVerPrt>> it = hashMap.entrySet().iterator();
            while (it.hasNext()) {
                ItemLocalVerPrt value = it.next().getValue();
                if (value != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("bid", CommonUtil.sParseBidId(value.mItemId));
                    jSONObject.put("scid", CommonUtil.sParseScid(value.mItemId));
                    jSONObject.put("version", value.mMd5);
                    jSONArray.mo162put(jSONObject);
                }
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
            VasUpdateWrapper.getLog().e(TAG, "parseItemLocalVerList exception", th5);
        }
        return jSONArray;
    }

    private void readLocalTable() {
        try {
            this.mArrayExistItem.clear();
            List<c.a> a16 = VasUpdateWrapper.getDbManager().a(0);
            if (a16 != null) {
                for (c.a aVar : a16) {
                    if (aVar != null && !TextUtils.isEmpty(aVar.f434915b)) {
                        this.mArrayExistItem.put(aVar.f434914a, ItemLocalVerPrt.parseJsonToItemLocalVerPrt(aVar.f434915b));
                    }
                    if (this.mArrayExistItem.size() > 1300) {
                        return;
                    }
                }
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
            VasUpdateWrapper.getLog().e(TAG, "readLocalTable exception", th5);
        }
    }

    public String getRequest() {
        this.mSyncMode = 1;
        if (this.mSeqConfig == null) {
            loadSeqConfig();
        }
        if (this.mSeqConfig.mSeq == 0) {
            this.mSyncMode = 0;
            readLocalTable();
        }
        return getRequestContent();
    }

    public void handlePbResponse(int i3, TaskSyncRsp taskSyncRsp) {
        VasUpdateWrapper.getLog().d(TAG, "sync handlePbResponse result = " + i3);
        if (i3 == 0 && taskSyncRsp != null) {
            if ((taskSyncRsp.mSyncSwitch & 1) != 0) {
                notifyComplete(2, "handlePbResponse syncSwitch close", null);
                return;
            }
            Preload preload = taskSyncRsp.mPreaload;
            if (preload != null) {
                int i16 = preload.mPreLoadVersion;
                SeqConfigEntity seqConfigEntity = this.mSeqConfig;
                if (i16 != seqConfigEntity.mPreloadVer) {
                    seqConfigEntity.mPreloadVer = i16;
                    ArrayList<PreloadItem> arrayList = preload.mItemList;
                    seqConfigEntity.mPreloadList = arrayList;
                    if (i16 == 0) {
                        arrayList.clear();
                    }
                }
            }
            HashMap<String, ItemUpdateVerPtr> shouldUpdateList = getShouldUpdateList(taskSyncRsp);
            SeqConfigEntity seqConfigEntity2 = this.mSeqConfig;
            seqConfigEntity2.mSeq = taskSyncRsp.mSeq;
            seqConfigEntity2.mAppVer = VasUpdateWrapper.getCommonManager().e();
            SeqConfigEntity seqConfigEntity3 = this.mSeqConfig;
            seqConfigEntity3.mPollTime = taskSyncRsp.mPollTime;
            SeqConfigEntity.saveSeqConfig(seqConfigEntity3);
            VasUpdateWrapper.getLog().i(TAG, "handlePbResponse listShouldUpdate count = " + shouldUpdateList.size());
            VasUpdateWrapper.getVasUpdateSystem().h(taskSyncRsp.mContinueFlag);
            notifyComplete(0, "sync success", shouldUpdateList);
            return;
        }
        VasUpdateWrapper.getLog().e(TAG, "handlePbResponse error");
        notifyComplete(1, "handlePbResponse result != 0 or rsp = null", null);
    }

    public void loadSeqConfig() {
        SeqConfigEntity loadSeqConfig = SeqConfigEntity.loadSeqConfig();
        this.mSeqConfig = loadSeqConfig;
        if (!TextUtils.isEmpty(loadSeqConfig.mAppVer) && !this.mSeqConfig.mAppVer.equalsIgnoreCase(VasUpdateWrapper.getCommonManager().e())) {
            this.mSeqConfig.mAppVer = VasUpdateWrapper.getCommonManager().e();
            SeqConfigEntity seqConfigEntity = this.mSeqConfig;
            seqConfigEntity.mPreloadVer = 0;
            SeqConfigEntity.saveSeqConfig(seqConfigEntity);
        }
    }

    public void onSendPbMsgError() {
        notifyComplete(3, "sync send pb error", null);
    }
}
