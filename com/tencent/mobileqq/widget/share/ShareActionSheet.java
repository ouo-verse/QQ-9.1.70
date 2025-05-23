package com.tencent.mobileqq.widget.share;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.widget.ActionSheet;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public interface ShareActionSheet {

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface OnItemClickListener {
        void onItemClick(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface a {
        void a(List<ResultRecord> list);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface b {
        View a();
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface c {
        void w6(View view, ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet);
    }

    void dismiss();

    void dismissImmediately();

    View findViewById(int i3);

    ActionSheet getActionSheet();

    int getActionSheetPanelViewHeight();

    Bundle getExtras();

    int getIconWidth();

    String getOpenSource();

    Window getWindow();

    void hideTitle();

    boolean isShowing();

    void onConfigurationChanged();

    void refresh();

    void setActionSheetItems(List<ShareActionSheetBuilder.ActionSheetItem> list, List<ShareActionSheetBuilder.ActionSheetItem> list2);

    @Deprecated
    void setActionSheetItems(List<ShareActionSheetBuilder.ActionSheetItem>[] listArr);

    void setActionSheetTitle(CharSequence charSequence);

    void setAdvBgColor(int i3);

    void setAdvView(View view, RelativeLayout.LayoutParams layoutParams);

    void setBottomBarInterface(b bVar);

    void setCancelListener(DialogInterface.OnCancelListener onCancelListener);

    void setEnableNotTriggerVirtualNavigationBar(boolean z16);

    void setExtras(Bundle bundle);

    void setIconMarginLeftRight(int i3);

    void setIntentForStartForwardRecentActivity(Intent intent);

    @Deprecated
    void setItemClickListener(AdapterView.OnItemClickListener onItemClickListener);

    void setItemClickListenerV2(OnItemClickListener onItemClickListener);

    void setItemClickListenerV3(c cVar);

    void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener);

    void setOnShowListener(DialogInterface.OnShowListener onShowListener);

    void setOpenSource(String str);

    void setRecentlyUserSorter(a aVar);

    void setRowMarginLeftRight(int i3);

    void setRowVisibility(int i3, int i16, int i17);

    void show();

    @Deprecated
    void updateUI();

    @Deprecated
    void updateUIIfShowing();
}
