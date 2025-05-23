package com.tencent.mobileqq.mini.share;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentCallItem;
import com.tencent.mobileqq.activity.recent.i;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QuickSendProgressView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.RecentDynamicAvatarView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

/* loaded from: classes33.dex */
public class MiniShareQuicklySendPanelAdapter extends BaseAdapter implements View.OnClickListener, DecodeTaskCompletionListener {
    private static final String TAG = "MiniShareQuicklySendPanelAdapter";
    private Activity activity;
    private QQAppInterface mApp;
    protected i mFaceDecoder;
    private XListView mListView;
    private Bundle mShareDataBundle;
    private Hashtable<String, Bitmap> faceCache = new Hashtable<>();
    private long decodeFaceStartTime = 0;
    private SendPanelViewHolder curShareViewHolder = null;
    private ArrayList<SendPanelData> sendPanelDataList = new ArrayList<>();

    /* loaded from: classes33.dex */
    public static class SendPanelData {
        public RecentBaseData baseData;
        public int operateStatus;
        public int position;

        public SendPanelData(RecentBaseData recentBaseData) {
            this.baseData = recentBaseData;
        }
    }

    /* loaded from: classes33.dex */
    public class SendPanelViewHolder {
        public RecentDynamicAvatarView iconView;
        public SendPanelData itemInfo;
        public TextView nameText;
        public QuickSendProgressView operateView;

        public SendPanelViewHolder() {
        }
    }

    public MiniShareQuicklySendPanelAdapter(Activity activity, QQAppInterface qQAppInterface, XListView xListView, Bundle bundle) {
        this.activity = activity;
        this.mApp = qQAppInterface;
        this.mListView = xListView;
        this.mShareDataBundle = bundle;
        this.mFaceDecoder = new i(qQAppInterface, this, false);
    }

    public static Drawable getIconDrawable(String str, int i3, int i16) {
        com.tencent.mobileqq.drawable.b bVar = new com.tencent.mobileqq.drawable.b(Color.rgb(214, 214, 214), i3, i16);
        if (!TextUtils.isEmpty(str)) {
            try {
                URLDrawable drawable = URLDrawable.getDrawable(str, bVar, bVar);
                if (drawable.getStatus() != 1) {
                    drawable.downloadImediatly();
                }
                return drawable;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "getIconDrawable Exception, coverUrl=" + str, e16);
                }
            }
        }
        return bVar;
    }

    private SendPanelData updateStatus(String str, int i3) {
        ArrayList<SendPanelData> arrayList;
        if (TextUtils.isEmpty(str) || (arrayList = this.sendPanelDataList) == null || arrayList.size() <= 0) {
            return null;
        }
        Iterator<SendPanelData> it = this.sendPanelDataList.iterator();
        while (it.hasNext()) {
            SendPanelData next = it.next();
            if (!TextUtils.isEmpty(next.baseData.getRecentUserUin()) && str.equals(next.baseData.getRecentUserUin())) {
                next.operateStatus = i3;
                return next;
            }
        }
        return null;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<SendPanelData> arrayList = this.sendPanelDataList;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        ArrayList<SendPanelData> arrayList = this.sendPanelDataList;
        if (arrayList != null) {
            return arrayList.get(i3);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        ArrayList<SendPanelData> arrayList = this.sendPanelDataList;
        if (arrayList == null || i3 >= arrayList.size()) {
            return 0L;
        }
        try {
            return Long.parseLong(this.sendPanelDataList.get(i3).baseData.getRecentUserUin());
        } catch (Exception e16) {
            if (!QLog.isColorLevel()) {
                return 0L;
            }
            QLog.d(TAG, 2, "getItemId exception = " + e16.getMessage());
            return 0L;
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        SendPanelData sendPanelData = (SendPanelData) getItem(i3);
        if (view == null) {
            View inflate = LayoutInflater.from(this.activity).inflate(R.layout.ceg, (ViewGroup) null);
            SendPanelViewHolder sendPanelViewHolder = new SendPanelViewHolder();
            sendPanelViewHolder.iconView = (RecentDynamicAvatarView) inflate.findViewById(R.id.icon);
            sendPanelViewHolder.nameText = (TextView) inflate.findViewById(R.id.f5e);
            sendPanelViewHolder.operateView = (QuickSendProgressView) inflate.findViewById(R.id.lyd);
            sendPanelViewHolder.itemInfo = sendPanelData;
            bindData(sendPanelViewHolder, null);
            inflate.setTag(sendPanelViewHolder);
            return inflate;
        }
        SendPanelViewHolder sendPanelViewHolder2 = (SendPanelViewHolder) view.getTag();
        sendPanelViewHolder2.itemInfo = sendPanelData;
        bindData(sendPanelViewHolder2, null);
        return view;
    }

    protected boolean needDynamic(RecentBaseData recentBaseData) {
        int recentUserType = recentBaseData.getRecentUserType();
        return recentUserType == 0 || recentUserType == 1000 || recentUserType == 1004 || recentUserType == 1003 || recentUserType == 10004 || recentUserType == 1021 || recentUserType == 1022 || recentUserType == 1023 || recentUserType == 10008;
    }

    public void notifyShareCancel() {
        SendPanelViewHolder sendPanelViewHolder = this.curShareViewHolder;
        if (sendPanelViewHolder != null) {
            SendPanelData updateStatus = updateStatus(sendPanelViewHolder.itemInfo.baseData.getRecentUserUin(), 0);
            if (updateStatus != null) {
                SendPanelViewHolder sendPanelViewHolder2 = this.curShareViewHolder;
                sendPanelViewHolder2.itemInfo = updateStatus;
                updateStatusView(sendPanelViewHolder2);
            }
            this.curShareViewHolder = null;
        }
    }

    public void notifyShareSuc() {
        SendPanelViewHolder sendPanelViewHolder = this.curShareViewHolder;
        if (sendPanelViewHolder != null) {
            SendPanelData updateStatus = updateStatus(sendPanelViewHolder.itemInfo.baseData.getRecentUserUin(), 3);
            if (updateStatus != null) {
                SendPanelViewHolder sendPanelViewHolder2 = this.curShareViewHolder;
                sendPanelViewHolder2.itemInfo = updateStatus;
                updateStatusView(sendPanelViewHolder2);
            }
            this.curShareViewHolder = null;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof SendPanelViewHolder) {
            SendPanelViewHolder sendPanelViewHolder = (SendPanelViewHolder) view.getTag();
            if (sendPanelViewHolder.itemInfo == null) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "onClick itemInfo is null");
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "onClick operateStatus = " + sendPanelViewHolder.itemInfo.operateStatus);
            }
            int i3 = sendPanelViewHolder.itemInfo.operateStatus;
            if (i3 != 0) {
                if (i3 == 2 && !NetworkUtil.isNetworkAvailable(this.activity)) {
                    Activity activity = this.activity;
                    QQToast.makeText(activity, activity.getString(R.string.vs8), 0).show();
                    return;
                }
                return;
            }
            if (!NetworkUtil.isNetworkAvailable(this.activity)) {
                Activity activity2 = this.activity;
                QQToast.makeText(activity2, activity2.getString(R.string.vs8), 0).show();
                return;
            }
            SendPanelData updateStatus = updateStatus(sendPanelViewHolder.itemInfo.baseData.getRecentUserUin(), 1);
            if (updateStatus != null) {
                sendPanelViewHolder.itemInfo = updateStatus;
                updateStatusView(sendPanelViewHolder);
                if (this.curShareViewHolder == null) {
                    this.curShareViewHolder = sendPanelViewHolder;
                }
            }
            MiniProgramShareUtils.shareToChatDirectly(this.activity, this.mShareDataBundle, sendPanelViewHolder.itemInfo.baseData.getRecentUserType(), String.valueOf(sendPanelViewHolder.itemInfo.baseData.getRecentUserUin()), sendPanelViewHolder.itemInfo.baseData.getTitleName(), MiniShareQuicklySendPanelFragment.QUCIKLY_SHARE_REQUEST_CODE, false);
        }
    }

    @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
    public void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
        SendPanelData sendPanelData;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (bitmap != null || i3 <= 0) {
            if (bitmap != null) {
                try {
                    this.faceCache.put(i16 + ":" + str, bitmap);
                } catch (OutOfMemoryError e16) {
                    System.gc();
                    e16.printStackTrace();
                    QLog.i(TAG, 1, "onDecodeTaskCompleted error:" + e16.getMessage());
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            long j3 = this.decodeFaceStartTime;
            boolean z16 = j3 > 0 && currentTimeMillis - j3 > 300;
            if (i3 <= 0 || z16) {
                synchronized (this.faceCache) {
                    if (this.faceCache.size() == 0) {
                        return;
                    }
                    if (i3 == 0) {
                        this.decodeFaceStartTime = 0L;
                    } else {
                        this.decodeFaceStartTime = currentTimeMillis;
                    }
                    int childCount = this.mListView.getChildCount();
                    boolean z17 = false;
                    for (int i17 = 0; i17 < childCount; i17++) {
                        SendPanelViewHolder sendPanelViewHolder = (SendPanelViewHolder) this.mListView.getChildAt(i17).getTag();
                        if (sendPanelViewHolder != null && (sendPanelData = sendPanelViewHolder.itemInfo) != null) {
                            SendPanelData sendPanelData2 = this.sendPanelDataList.get(sendPanelData.position);
                            if (sendPanelData2 != null) {
                                int intValue = ((Integer) i.n(this.mApp, sendPanelData2.baseData.getRecentUserType(), sendPanelData2.baseData.getRecentUserUin()).first).intValue();
                                if (intValue != Integer.MIN_VALUE) {
                                    Bitmap bitmap2 = this.faceCache.get(intValue + ":" + sendPanelData2.baseData.getRecentUserUin());
                                    if (bitmap2 != null) {
                                        updateItem(sendPanelViewHolder, sendPanelData2, new BitmapDrawable(this.activity.getResources(), bitmap2));
                                        z17 = true;
                                    }
                                }
                            }
                        } else {
                            QLog.e(TAG, 1, "onDecodeTaskCompleted holder is null?!");
                        }
                    }
                    if (QLog.isDevelopLevel()) {
                        QLog.i(TAG, 4, "decodecomplete|faceCache size = " + this.faceCache.size() + ", isNeedUpdateAvatar=" + z17);
                    }
                    this.faceCache.clear();
                }
            }
        }
    }

    public void onDestroy() {
        i iVar = this.mFaceDecoder;
        if (iVar != null) {
            iVar.r();
        }
    }

    private void updateStatusView(SendPanelViewHolder sendPanelViewHolder) {
        if (sendPanelViewHolder != null && sendPanelViewHolder.itemInfo != null) {
            QLog.d(TAG, 2, "updateStatusView");
            sendPanelViewHolder.operateView.setStatus(sendPanelViewHolder.itemInfo.operateStatus);
        } else if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "updateStatusView fail");
        }
    }

    public void bindData(SendPanelViewHolder sendPanelViewHolder, Drawable drawable) {
        SendPanelData sendPanelData;
        if (sendPanelViewHolder != null && (sendPanelData = sendPanelViewHolder.itemInfo) != null) {
            if (drawable == null) {
                i iVar = this.mFaceDecoder;
                drawable = iVar != null ? iVar.g(sendPanelData.baseData) : null;
            }
            Drawable drawable2 = drawable;
            if (needDynamic(sendPanelData.baseData)) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "bindview user:" + sendPanelData.baseData.getRecentUserUin());
                }
                int intValue = ((Integer) i.n(this.mApp, sendPanelData.baseData.getRecentUserType(), sendPanelData.baseData.getRecentUserUin()).first).intValue();
                sendPanelViewHolder.iconView.setFaceDrawable(this.mApp, drawable2, intValue == 103 ? 1 : intValue, sendPanelData.baseData.getRecentUserUin(), 100, false, this.mApp.mAutomator.getInActionLoginB() == 1, 0);
            } else {
                sendPanelViewHolder.iconView.setImageDrawable(drawable2);
            }
            sendPanelViewHolder.nameText.setText(sendPanelData.baseData.getTitleName());
            sendPanelViewHolder.operateView.setTag(sendPanelViewHolder);
            sendPanelViewHolder.operateView.setOnClickListener(this);
            updateStatusView(sendPanelViewHolder);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "bindData fail viewHolder");
        }
    }

    public void setData(ArrayList<SendPanelData> arrayList) {
        if (arrayList == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "setData list is empty");
            }
        } else if (this.sendPanelDataList != null && arrayList.isEmpty()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "setData do not need refresh");
            }
        } else {
            this.sendPanelDataList = arrayList;
            notifyDataSetChanged();
        }
    }

    public void onUpdate(int i3, SendPanelData sendPanelData) {
        ArrayList<SendPanelData> arrayList;
        if (i3 >= 0 && (arrayList = this.sendPanelDataList) != null && i3 <= arrayList.size() && sendPanelData != null) {
            this.sendPanelDataList.set(i3, sendPanelData);
        } else if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onUpdate return");
        }
    }

    private void updateItem(SendPanelViewHolder sendPanelViewHolder, SendPanelData sendPanelData, Drawable drawable) {
        if (sendPanelViewHolder == null || sendPanelData == null) {
            return;
        }
        if (drawable == null) {
            int recentUserType = sendPanelData.baseData.getRecentUserType();
            RecentBaseData recentBaseData = sendPanelData.baseData;
            if ((recentBaseData instanceof RecentCallItem) && ((RecentCallItem) recentBaseData).a()) {
                recentUserType = 3002;
            }
            drawable = this.mFaceDecoder.e(recentUserType, sendPanelData.baseData.getRecentUserUin());
        }
        bindData(sendPanelViewHolder, drawable);
    }
}
