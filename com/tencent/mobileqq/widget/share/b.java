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
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b extends a {

    /* renamed from: d, reason: collision with root package name */
    private ShareActionSheetV2 f317499d;

    /* renamed from: e, reason: collision with root package name */
    private Validator f317500e;

    public b(ShareActionSheetV2 shareActionSheetV2) {
        this.f317499d = shareActionSheetV2;
        this.f317500e = new Validator(shareActionSheetV2);
    }

    public void a(View.OnClickListener onClickListener) {
        this.f317499d.setClickCancelBtnListener(onClickListener);
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void dismiss() {
        this.f317499d.dismiss();
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void dismissImmediately() {
        this.f317499d.dismissImmediately();
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public View findViewById(int i3) {
        return this.f317499d.findViewById(i3);
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public ActionSheet getActionSheet() {
        throw new IllegalStateException("not impl in ShareActionSheetImplV2");
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public int getActionSheetPanelViewHeight() {
        return this.f317499d.getActionSheetPanelViewHeight();
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public Bundle getExtras() {
        return this.f317499d.getExtras();
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public int getIconWidth() {
        return this.f317499d.getIconWidth();
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public String getOpenSource() {
        throw new IllegalStateException("not impl in ShareActionSheetImplV2");
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public Window getWindow() {
        return this.f317499d.getWindow();
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void hideTitle() {
        this.f317499d.hideTitle();
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public boolean isShowing() {
        return this.f317499d.isShowing();
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void onConfigurationChanged() {
        this.f317499d.onConfigurationChanged();
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void refresh() {
        this.f317499d.refresh();
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setActionSheetItems(List<ShareActionSheetBuilder.ActionSheetItem>[] listArr) {
        this.f317499d.setActionSheetItems(listArr);
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setActionSheetTitle(CharSequence charSequence) {
        this.f317499d.setActionSheetTitle(charSequence);
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setAdvBgColor(int i3) {
        this.f317499d.setAdvBgColor(i3);
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setAdvView(View view, RelativeLayout.LayoutParams layoutParams) {
        this.f317499d.setAdvView(view, layoutParams);
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setBottomBarInterface(ShareActionSheet.b bVar) {
        this.f317499d.setBottomBarInterface(bVar);
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        this.f317499d.setCancelListener(onCancelListener);
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setEnableNotTriggerVirtualNavigationBar(boolean z16) {
        this.f317499d.setEnableNotTriggerVirtualNavigationBar(z16);
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setExtras(Bundle bundle) {
        this.f317499d.setExtras(bundle);
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setIconMarginLeftRight(int i3) {
        this.f317499d.setIconMarginLeftRight(i3);
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setIntentForStartForwardRecentActivity(Intent intent) {
        this.f317499d.setIntentForStartForwardRecentActivity(intent);
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.f317499d.setItemClickListener(onItemClickListener);
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setItemClickListenerV2(ShareActionSheet.OnItemClickListener onItemClickListener) {
        this.f317499d.setItemClickListenerV2(onItemClickListener);
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setItemClickListenerV3(ShareActionSheet.c cVar) {
        this.f317499d.setItemClickListenerV3(cVar);
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.f317499d.setOnDismissListener(onDismissListener);
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setOnShowListener(DialogInterface.OnShowListener onShowListener) {
        this.f317499d.setOnShowListener(onShowListener);
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setOpenSource(String str) {
        throw new IllegalStateException("not impl in ShareActionSheetImplV2");
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setRecentlyUserSorter(ShareActionSheet.a aVar) {
        this.f317499d.setRecentlyUserSorter(aVar);
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setRowMarginLeftRight(int i3) {
        this.f317499d.setRowMarginLeftRight(i3);
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setRowVisibility(int i3, int i16, int i17) {
        this.f317499d.setRowVisibility(i3, i16, i17);
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void show() {
        if (this.f317500e.b()) {
            this.f317499d.show();
        } else if (QLog.isColorLevel()) {
            QLog.d("ShareActionSheetImplV2", 2, "show() called \u53c2\u6570\u65e0\u6548");
        }
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void updateUI() {
        this.f317499d.refresh();
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void updateUIIfShowing() {
        this.f317499d.refresh();
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet
    public void setActionSheetItems(List<ShareActionSheetBuilder.ActionSheetItem> list, List<ShareActionSheetBuilder.ActionSheetItem> list2) {
        this.f317499d.setActionSheetItems(list, list2);
    }
}
