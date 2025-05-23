package com.tencent.mobileqq.widget.share;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.widget.ActionSheet;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public class c implements ShareActionSheet {

    /* renamed from: d, reason: collision with root package name */
    private ShareActionSheet f317501d;

    public c(ShareActionSheet shareActionSheet) {
        this.f317501d = shareActionSheet;
    }

    public void a(View.OnClickListener onClickListener) {
        ShareActionSheet shareActionSheet = this.f317501d;
        if (shareActionSheet instanceof b) {
            ((b) shareActionSheet).a(onClickListener);
        }
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void dismiss() {
        this.f317501d.dismiss();
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void dismissImmediately() {
        this.f317501d.dismissImmediately();
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public View findViewById(int i3) {
        return this.f317501d.findViewById(i3);
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public ActionSheet getActionSheet() {
        return this.f317501d.getActionSheet();
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public int getActionSheetPanelViewHeight() {
        return this.f317501d.getActionSheetPanelViewHeight();
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public Bundle getExtras() {
        return this.f317501d.getExtras();
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public int getIconWidth() {
        return this.f317501d.getIconWidth();
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public String getOpenSource() {
        return this.f317501d.getOpenSource();
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public Window getWindow() {
        return this.f317501d.getWindow();
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void hideTitle() {
        this.f317501d.hideTitle();
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public boolean isShowing() {
        return this.f317501d.isShowing();
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void onConfigurationChanged() {
        this.f317501d.onConfigurationChanged();
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void refresh() {
        this.f317501d.refresh();
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setActionSheetItems(List<ShareActionSheetBuilder.ActionSheetItem>[] listArr) {
        this.f317501d.setActionSheetItems(listArr);
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setActionSheetTitle(CharSequence charSequence) {
        this.f317501d.setActionSheetTitle(charSequence);
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setAdvBgColor(int i3) {
        this.f317501d.setAdvBgColor(i3);
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setAdvView(View view, RelativeLayout.LayoutParams layoutParams) {
        this.f317501d.setAdvView(view, layoutParams);
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setBottomBarInterface(ShareActionSheet.b bVar) {
        this.f317501d.setBottomBarInterface(bVar);
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        this.f317501d.setCancelListener(onCancelListener);
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setEnableNotTriggerVirtualNavigationBar(boolean z16) {
        this.f317501d.setEnableNotTriggerVirtualNavigationBar(z16);
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setExtras(Bundle bundle) {
        this.f317501d.setExtras(bundle);
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setIconMarginLeftRight(int i3) {
        this.f317501d.setIconMarginLeftRight(i3);
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setIntentForStartForwardRecentActivity(Intent intent) {
        this.f317501d.setIntentForStartForwardRecentActivity(intent);
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.f317501d.setItemClickListener(onItemClickListener);
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setItemClickListenerV2(ShareActionSheet.OnItemClickListener onItemClickListener) {
        this.f317501d.setItemClickListenerV2(onItemClickListener);
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setItemClickListenerV3(ShareActionSheet.c cVar) {
        this.f317501d.setItemClickListenerV3(cVar);
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.f317501d.setOnDismissListener(onDismissListener);
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setOnShowListener(DialogInterface.OnShowListener onShowListener) {
        this.f317501d.setOnShowListener(onShowListener);
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setOpenSource(String str) {
        this.f317501d.setOpenSource(str);
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setRecentlyUserSorter(ShareActionSheet.a aVar) {
        this.f317501d.setRecentlyUserSorter(aVar);
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setRowMarginLeftRight(int i3) {
        this.f317501d.setRowMarginLeftRight(i3);
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setRowVisibility(int i3, int i16, int i17) {
        this.f317501d.setRowVisibility(i3, i16, i17);
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void show() {
        this.f317501d.show();
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void updateUI() {
        this.f317501d.updateUI();
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void updateUIIfShowing() {
        this.f317501d.updateUIIfShowing();
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setActionSheetItems(List<ShareActionSheetBuilder.ActionSheetItem> list, List<ShareActionSheetBuilder.ActionSheetItem> list2) {
        this.f317501d.setActionSheetItems(list, list2);
    }
}
