package com.tencent.mobileqq.emoticonview.ipc.proxy;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.emosm.api.ICommonUsedSystemEmojiManagerService;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.pb.emosm.EmosmPb$SmallYellowItem;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

/* loaded from: classes12.dex */
public class CommonUsedSystemEmojiManagerServiceProxy extends AbsEmoRuntimeServiceProxy<ICommonUsedSystemEmojiManagerService> {
    static IPatchRedirector $redirector_ = null;
    public static final String ACTION_COMMONUSEDSYSTEMEMOJI_INFO = "common_usedsystememoji_info";
    public static final String ACTION_COMMONUSEDSYSTEMEMOJI_SAVE_INFO = "common_usedsystememoji_saveInfo";
    public static final String ACTION_COMMONUSEDSYSTEMEMOJI_SAVE_INFO_TO_CACHE = "common_usedsystememoji_saveinfo_to_cache";
    public static final String COMMONUSED_INFO_DATA = "commonused_info_data";
    public static final String INFO_COUNT = "info_count";
    public static final String INFO_ID = "info_id";
    public static final String INFO_TS = "info_ts";
    public static final String INFO_TYPE = "info_type";
    public static final String TAG = "CommonUsedSystemEmojiManagerServiceProxy";

    public CommonUsedSystemEmojiManagerServiceProxy(BaseQQAppInterface baseQQAppInterface) {
        super(baseQQAppInterface, ICommonUsedSystemEmojiManagerService.class);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseQQAppInterface);
        }
    }

    public static EIPCResult checkMatch(AppRuntime appRuntime, String str, Bundle bundle, int i3) {
        if (ACTION_COMMONUSEDSYSTEMEMOJI_INFO.equals(str)) {
            return onGetCommonUsedSystemEmojiInfo((BaseQQAppInterface) appRuntime, str, bundle, i3);
        }
        if (ACTION_COMMONUSEDSYSTEMEMOJI_SAVE_INFO.equals(str)) {
            return onSaveSystemEmojiInfoToFile((BaseQQAppInterface) appRuntime, str, bundle, i3);
        }
        if (ACTION_COMMONUSEDSYSTEMEMOJI_SAVE_INFO_TO_CACHE.equals(str)) {
            return onSaveSystemEmojiInfoToCache((BaseQQAppInterface) appRuntime, str, bundle, i3);
        }
        return null;
    }

    public static EIPCResult onGetCommonUsedSystemEmojiInfo(BaseQQAppInterface baseQQAppInterface, String str, Bundle bundle, int i3) {
        List<EmosmPb$SmallYellowItem> commonUsedSystemEmojiInfo = ((ICommonUsedSystemEmojiManagerService) baseQQAppInterface.getRuntimeService(ICommonUsedSystemEmojiManagerService.class)).getCommonUsedSystemEmojiInfo();
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        if (commonUsedSystemEmojiInfo != null) {
            for (EmosmPb$SmallYellowItem emosmPb$SmallYellowItem : commonUsedSystemEmojiInfo) {
                Bundle bundle2 = new Bundle();
                bundle2.putInt(INFO_ID, emosmPb$SmallYellowItem.f342125id.get());
                bundle2.putInt(INFO_TYPE, emosmPb$SmallYellowItem.type.get());
                bundle2.putInt(INFO_COUNT, emosmPb$SmallYellowItem.count.get());
                bundle2.putLong(INFO_TS, emosmPb$SmallYellowItem.f342126ts.get());
                arrayList.add(bundle2);
            }
        }
        Bundle bundle3 = new Bundle();
        bundle3.putParcelableArrayList(COMMONUSED_INFO_DATA, arrayList);
        return EIPCResult.createSuccessResult(bundle3);
    }

    public static EIPCResult onSaveSystemEmojiInfoToCache(BaseQQAppInterface baseQQAppInterface, String str, Bundle bundle, int i3) {
        if (bundle == null) {
            QLog.e(TAG, 4, "IPC onSaveSystemEmojiInfoToCache params is null");
            return EIPCResult.createResult(-102, null);
        }
        EmosmPb$SmallYellowItem emosmPb$SmallYellowItem = new EmosmPb$SmallYellowItem();
        int i16 = bundle.getInt(INFO_ID, 0);
        int i17 = bundle.getInt(INFO_TYPE, 0);
        if (i16 != 0 && i17 != 0) {
            emosmPb$SmallYellowItem.f342125id.set(i16);
            emosmPb$SmallYellowItem.type.set(i17);
            emosmPb$SmallYellowItem.count.set(bundle.getInt(INFO_COUNT, 0));
            emosmPb$SmallYellowItem.f342126ts.set(bundle.getLong(INFO_TS, 0L));
            ((ICommonUsedSystemEmojiManagerService) baseQQAppInterface.getRuntimeService(ICommonUsedSystemEmojiManagerService.class)).saveSystemEmojiInfoToCahce(emosmPb$SmallYellowItem);
            return EIPCResult.createSuccessResult(null);
        }
        QLog.e(TAG, 4, "IPC onSaveSystemEmojiInfoToCache id=" + i16 + ",type =" + i17);
        return EIPCResult.createSuccessResult(null);
    }

    public static EIPCResult onSaveSystemEmojiInfoToFile(BaseQQAppInterface baseQQAppInterface, String str, Bundle bundle, int i3) {
        ((ICommonUsedSystemEmojiManagerService) baseQQAppInterface.getRuntimeService(ICommonUsedSystemEmojiManagerService.class)).saveSystemEmojiInfoToFile();
        return EIPCResult.createSuccessResult(null);
    }

    public List<EmosmPb$SmallYellowItem> getCommonUsedSystemEmojiInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        T t16 = this.manager;
        if (t16 != 0) {
            return ((ICommonUsedSystemEmojiManagerService) t16).getCommonUsedSystemEmojiInfo();
        }
        ArrayList arrayList = new ArrayList();
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "module_emoticon_mainpanel", ACTION_COMMONUSEDSYSTEMEMOJI_INFO, null);
        if (callServer != null && callServer.isSuccess()) {
            Iterator it = callServer.data.getParcelableArrayList(COMMONUSED_INFO_DATA).iterator();
            while (it.hasNext()) {
                Bundle bundle = (Bundle) it.next();
                EmosmPb$SmallYellowItem emosmPb$SmallYellowItem = new EmosmPb$SmallYellowItem();
                emosmPb$SmallYellowItem.f342125id.set(bundle.getInt(INFO_ID, 0));
                emosmPb$SmallYellowItem.type.set(bundle.getInt(INFO_TYPE, 0));
                emosmPb$SmallYellowItem.count.set(bundle.getInt(INFO_COUNT, 0));
                emosmPb$SmallYellowItem.f342126ts.set(bundle.getLong(INFO_TS, 0L));
                arrayList.add(emosmPb$SmallYellowItem);
            }
            return arrayList;
        }
        QLog.e(TAG, 4, "getCommonUsedSystemEmojiInfo fail.");
        return arrayList;
    }

    public void saveSystemEmojiInfoToCache(EmosmPb$SmallYellowItem emosmPb$SmallYellowItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) emosmPb$SmallYellowItem);
            return;
        }
        T t16 = this.manager;
        if (t16 != 0) {
            ((ICommonUsedSystemEmojiManagerService) t16).saveSystemEmojiInfoToCahce(emosmPb$SmallYellowItem);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(INFO_ID, emosmPb$SmallYellowItem.f342125id.get());
        bundle.putInt(INFO_TYPE, emosmPb$SmallYellowItem.type.get());
        bundle.putInt(INFO_COUNT, emosmPb$SmallYellowItem.count.get());
        bundle.putLong(INFO_TS, emosmPb$SmallYellowItem.f342126ts.get());
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "module_emoticon_mainpanel", ACTION_COMMONUSEDSYSTEMEMOJI_SAVE_INFO_TO_CACHE, bundle);
        if (callServer != null && callServer.isSuccess()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 4, "saveSystemEmojiInfoToCahce suc.");
                return;
            }
            return;
        }
        QLog.e(TAG, 4, "saveSystemEmojiInfoToCahce fail.");
    }

    public void saveSystemEmojiInfoToFile() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        T t16 = this.manager;
        if (t16 != 0) {
            ((ICommonUsedSystemEmojiManagerService) t16).saveSystemEmojiInfoToFile();
            return;
        }
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "module_emoticon_mainpanel", ACTION_COMMONUSEDSYSTEMEMOJI_SAVE_INFO, null);
        if (callServer != null && callServer.isSuccess()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 4, "saveSystemEmojiInfoToFile suc.");
                return;
            }
            return;
        }
        QLog.e(TAG, 4, "saveSystemEmojiInfoToFile fail.");
    }
}
