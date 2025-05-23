package com.tencent.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ActionSheetAdapter extends BaseAdapter {
    static IPatchRedirector $redirector_ = null;
    public static final int CHANNEL_COPY = 4;
    public static final int CHANNEL_FACE2FACE_SHARE_TROOP = 7;
    public static final int CHANNEL_FRESHNEWS = 6;
    public static final int CHANNEL_INVALID = -1;
    public static final int CHANNEL_QQ = 0;
    public static final int CHANNEL_QR_CODE = 5;
    public static final int CHANNEL_QZONE = 1;
    public static final int CHANNEL_WX_FRIEND = 2;
    public static final int CHANNEL_WX_FRIEND_CIRCLE = 3;
    Context mContext;
    final List<ShareChanelInfo> mData;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class CustomDismissListener implements DialogInterface.OnDismissListener {
        static IPatchRedirector $redirector_;
        private WeakReference<DialogInterface.OnDismissListener> mDismissLis;

        public CustomDismissListener(DialogInterface.OnDismissListener onDismissListener) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) onDismissListener);
            } else {
                this.mDismissLis = new WeakReference<>(onDismissListener);
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
                return;
            }
            DialogInterface.OnDismissListener onDismissListener = this.mDismissLis.get();
            if (onDismissListener != null) {
                onDismissListener.onDismiss(dialogInterface);
            } else if (QLog.isColorLevel()) {
                QLog.i(LogTag.DATING, 2, "CustomDismissListener, lis is null");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class ShareChanelInfo {
        static IPatchRedirector $redirector_;
        public int chanelId;
        public int descId;
        public int iconId;
        public int textId;

        public ShareChanelInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public ActionSheetAdapter(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.mContext = context;
            this.mData = new ArrayList();
        }
    }

    public static ActionSheet createShareActionSheet(Context context, ActionSheetAdapter actionSheetAdapter, AdapterView.OnItemClickListener onItemClickListener, DialogInterface.OnDismissListener onDismissListener, ActionSheet.OnButtonClickListener onButtonClickListener, boolean z16) {
        if (context == null || actionSheetAdapter == null) {
            return null;
        }
        ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(context, null);
        android.widget.GridView gridView = (android.widget.GridView) View.inflate(context, R.layout.c2_, null);
        gridView.setBackgroundResource(R.drawable.mini_sdk_actionsheet_single_normal);
        gridView.setAdapter((ListAdapter) actionSheetAdapter);
        gridView.setOnItemClickListener(onItemClickListener);
        actionSheet.addView(gridView);
        actionSheet.addCancelButton(R.string.cancel);
        if (z16) {
            actionSheet.setOnDismissListener(new CustomDismissListener(onDismissListener));
        } else {
            actionSheet.setOnDismissListener(onDismissListener);
        }
        actionSheet.setOnButtonClickListener(onButtonClickListener);
        return actionSheet;
    }

    public static ShareChanelInfo createShareDefaultChanelInfo(int i3) {
        if (i3 >= 0 && i3 <= 7) {
            ShareChanelInfo shareChanelInfo = new ShareChanelInfo();
            switch (i3) {
                case 0:
                    shareChanelInfo.chanelId = 0;
                    shareChanelInfo.textId = R.string.bd6;
                    shareChanelInfo.iconId = R.drawable.cck;
                    shareChanelInfo.descId = R.string.hwp;
                    return shareChanelInfo;
                case 1:
                    shareChanelInfo.chanelId = 1;
                    shareChanelInfo.textId = R.string.hji;
                    shareChanelInfo.iconId = R.drawable.ccl;
                    shareChanelInfo.descId = R.string.hwq;
                    return shareChanelInfo;
                case 2:
                    shareChanelInfo.chanelId = 2;
                    shareChanelInfo.textId = R.string.hjo;
                    shareChanelInfo.iconId = R.drawable.cco;
                    shareChanelInfo.descId = R.string.hwx;
                    return shareChanelInfo;
                case 3:
                    shareChanelInfo.chanelId = 3;
                    shareChanelInfo.textId = R.string.hjd;
                    shareChanelInfo.iconId = R.drawable.cci;
                    shareChanelInfo.descId = R.string.hwg;
                    return shareChanelInfo;
                case 4:
                    shareChanelInfo.chanelId = 4;
                    shareChanelInfo.iconId = R.drawable.ccg;
                    shareChanelInfo.textId = R.string.f173139hj3;
                    shareChanelInfo.descId = R.string.hw_;
                    return shareChanelInfo;
                case 5:
                    shareChanelInfo.chanelId = 5;
                    shareChanelInfo.textId = R.string.f172949g21;
                    shareChanelInfo.iconId = R.drawable.die;
                    shareChanelInfo.descId = R.string.b1o;
                    return shareChanelInfo;
                case 6:
                    shareChanelInfo.chanelId = 4;
                    shareChanelInfo.iconId = R.drawable.ccg;
                    shareChanelInfo.textId = R.string.f173137hj1;
                    shareChanelInfo.descId = R.string.hwf;
                    return shareChanelInfo;
                case 7:
                    shareChanelInfo.chanelId = 7;
                    shareChanelInfo.iconId = R.drawable.cch;
                    shareChanelInfo.textId = R.string.his;
                    shareChanelInfo.descId = R.string.hwc;
                    return shareChanelInfo;
                default:
                    return shareChanelInfo;
            }
        }
        return null;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.mData.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return iPatchRedirector.redirect((short) 4, (Object) this, i3);
        }
        if (i3 >= 0 && i3 < this.mData.size()) {
            return this.mData.get(i3);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this, i3)).longValue();
        }
        if (((ShareChanelInfo) getItem(i3)) != null) {
            return r4.chanelId;
        }
        return -1L;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        View view2;
        View view3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            view2 = (View) iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), view, viewGroup);
            view3 = view;
        } else {
            ShareChanelInfo shareChanelInfo = (ShareChanelInfo) getItem(i3);
            if (view == null) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.c1l, (ViewGroup) null);
            }
            ImageView imageView = (ImageView) view.findViewById(R.id.f164379vi);
            TextView textView = (TextView) view.findViewById(R.id.f164389w0);
            if (shareChanelInfo != null) {
                imageView.setImageResource(shareChanelInfo.iconId);
                textView.setText(shareChanelInfo.textId);
            } else {
                imageView.setImageResource(R.drawable.qzone_icon_action_sheet_qq);
                textView.setText("");
            }
            if (AppSetting.f99565y) {
                if (shareChanelInfo != null) {
                    view.setContentDescription(this.mContext.getString(shareChanelInfo.descId));
                } else {
                    view.setContentDescription("");
                }
            }
            view2 = view;
            view3 = view2;
        }
        EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
        return view2;
    }

    public void setData(List<ShareChanelInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
            return;
        }
        this.mData.clear();
        if (list != null && list.size() > 0) {
            for (ShareChanelInfo shareChanelInfo : list) {
                if (shareChanelInfo != null && shareChanelInfo.chanelId >= 0) {
                    this.mData.add(shareChanelInfo);
                }
            }
        }
        notifyDataSetChanged();
    }
}
