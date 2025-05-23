package com.tencent.sqshow.zootopia.nativeui.dialog.views.actionsheet;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.nativeui.data.j;
import com.tencent.sqshow.zootopia.nativeui.dialog.views.actionsheet.AvatarActionSheetDialogView;
import com.tencent.sqshow.zootopia.nativeui.view.dialog.BasePanelDialogView;
import com.tencent.sqshow.zootopia.utils.aa;
import com.tencent.sqshow.zootopia.utils.i;
import com.tencent.sqshow.zootopia.view.ZplanExcludeFontPaddingTextView;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import l94.AvatarActionSheetDialogCustomData;
import l94.AvatarActionSheetDialogMenuItem;
import l94.d;
import l94.e;
import m84.b;
import n74.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000  2\u00020\u0001:\u0001!B7\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0006\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010\n\u001a\u00020\bH\u0014R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR0\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u000fj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b`\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\""}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/dialog/views/actionsheet/AvatarActionSheetDialogView;", "Lcom/tencent/sqshow/zootopia/nativeui/view/dialog/BasePanelDialogView;", "Ln74/h;", "binding", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "", "menuId", "Landroid/view/View;", "P", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ll94/b;", "D", "Ll94/b;", "mData", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "E", "Ljava/util/HashMap;", "menuItemViewCache", UserInfo.SEX_FEMALE, "Landroid/view/View;", "cancelView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", WadlProxyConsts.CHANNEL, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/tencent/sqshow/zootopia/nativeui/data/j;Ll94/b;)V", "G", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public class AvatarActionSheetDialogView extends BasePanelDialogView {

    /* renamed from: D, reason: from kotlin metadata */
    private final AvatarActionSheetDialogCustomData mData;

    /* renamed from: E, reason: from kotlin metadata */
    private final HashMap<Integer, View> menuItemViewCache;

    /* renamed from: F, reason: from kotlin metadata */
    private View cancelView;

    public /* synthetic */ AvatarActionSheetDialogView(Context context, AttributeSet attributeSet, int i3, j jVar, AvatarActionSheetDialogCustomData avatarActionSheetDialogCustomData, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3, jVar, avatarActionSheetDialogCustomData);
    }

    private final void Q(h binding) {
        String str;
        String pageId = this.mData.getPageId();
        if (pageId != null) {
            ZplanViewReportHelper mReporter = getMChannel().getReporter().getMReporter();
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            LinearLayout root = binding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            mReporter.a(context, root, pageId, getMChannel().getReporter().b());
        }
        int i3 = 0;
        if (TextUtils.isEmpty(this.mData.getMenuTitle())) {
            binding.f419346e.setVisibility(8);
            binding.f419345d.setVisibility(8);
        } else {
            binding.f419346e.setVisibility(0);
            binding.f419345d.setVisibility(0);
            binding.f419345d.setText(this.mData.getMenuTitle());
        }
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.f11133y);
        int size = this.mData.b().size();
        while (i3 < size) {
            final AvatarActionSheetDialogMenuItem avatarActionSheetDialogMenuItem = this.mData.b().get(i3);
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView = new ZplanExcludeFontPaddingTextView(context2);
            zplanExcludeFontPaddingTextView.setText(avatarActionSheetDialogMenuItem.getMenuContent());
            zplanExcludeFontPaddingTextView.setGravity(17);
            zplanExcludeFontPaddingTextView.setBackgroundResource((i3 == 0 && binding.f419345d.getVisibility() == 8) ? R.drawable.hmh : R.drawable.hmg);
            zplanExcludeFontPaddingTextView.setTextSize(1, 17.0f);
            if (avatarActionSheetDialogMenuItem.getMenuType() == 3) {
                str = "#FF5967";
            } else {
                str = "#000000";
            }
            b.g(zplanExcludeFontPaddingTextView, str);
            zplanExcludeFontPaddingTextView.setLayoutParams(new LinearLayout.LayoutParams(-1, dimensionPixelSize));
            View view = new View(getContext());
            view.setBackgroundColor(Color.parseColor("#F5F5F5"));
            view.setLayoutParams(new LinearLayout.LayoutParams(-1, i.a(1.0f)));
            binding.f419344c.addView(zplanExcludeFontPaddingTextView);
            binding.f419344c.addView(view);
            this.menuItemViewCache.put(Integer.valueOf(avatarActionSheetDialogMenuItem.getMenuId()), zplanExcludeFontPaddingTextView);
            aa.d(zplanExcludeFontPaddingTextView, new View.OnClickListener() { // from class: x94.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    AvatarActionSheetDialogView.R(AvatarActionSheetDialogMenuItem.this, this, view2);
                }
            });
            avatarActionSheetDialogMenuItem.getItemClickListener().b(zplanExcludeFontPaddingTextView);
            d itemAddListener = avatarActionSheetDialogMenuItem.getItemAddListener();
            if (itemAddListener != null) {
                itemAddListener.a(avatarActionSheetDialogMenuItem.getMenuType(), avatarActionSheetDialogMenuItem.getMenuId(), zplanExcludeFontPaddingTextView);
            }
            i3++;
        }
        ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView2 = binding.f419343b;
        Intrinsics.checkNotNullExpressionValue(zplanExcludeFontPaddingTextView2, "binding.actionsheetCancel");
        aa.d(zplanExcludeFontPaddingTextView2, new View.OnClickListener() { // from class: x94.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AvatarActionSheetDialogView.S(AvatarActionSheetDialogView.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(AvatarActionSheetDialogMenuItem menuItem, AvatarActionSheetDialogView this$0, View it) {
        Intrinsics.checkNotNullParameter(menuItem, "$menuItem");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("AvatarActionSheetDialogView", 1, "click - " + menuItem.getMenuId() + "-" + menuItem.getMenuContent());
        e itemClickListener = menuItem.getItemClickListener();
        int menuType = menuItem.getMenuType();
        int menuId = menuItem.getMenuId();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        itemClickListener.a(menuType, menuId, it);
        this$0.getMChannel().getDialogController().g(this$0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(AvatarActionSheetDialogView this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("AvatarActionSheetDialogView", 1, "click - Cancel");
        e cancelClickListener = this$0.mData.getCancelClickListener();
        if (cancelClickListener != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            cancelClickListener.a(1, -1, it);
        }
        this$0.getMChannel().getDialogController().g(this$0);
    }

    public final View P(int menuId) {
        return this.menuItemViewCache.get(Integer.valueOf(menuId));
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.BasePanelDialogView
    protected View m() {
        h g16 = h.g(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context))");
        Q(g16);
        this.cancelView = g16.f419343b;
        LinearLayout root = g16.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvatarActionSheetDialogView(Context context, AttributeSet attributeSet, int i3, j channel, AvatarActionSheetDialogCustomData mData) {
        super(context, attributeSet, i3, channel);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(mData, "mData");
        this.mData = mData;
        this.menuItemViewCache = new HashMap<>();
    }
}
