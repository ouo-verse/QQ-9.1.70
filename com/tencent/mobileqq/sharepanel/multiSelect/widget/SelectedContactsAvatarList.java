package com.tencent.mobileqq.sharepanel.multiSelect.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.sharepanel.model.SharePanelContactItem;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 #2\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u0010 \u001a\u00020\b\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0014\u0010\r\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bR\u0016\u0010\u0010\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000fR\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/multiSelect/widget/SelectedContactsAvatarList;", "Landroid/widget/LinearLayout;", "", "c", "Landroid/view/View;", "b", "Lcom/tencent/mobileqq/sharepanel/model/SharePanelContactItem;", "data", "", NodeProps.MARGIN_RIGHT, "a", "", "newList", "setData", "d", "I", "avatarSize", "e", "moreImageSize", "f", NodeProps.BORDER_WIDTH, h.F, "Landroid/view/View;", "moreItem", "", "i", "Ljava/util/List;", "dataList", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SelectedContactsAvatarList extends LinearLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int avatarSize;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int moreImageSize;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int borderWidth;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View moreItem;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<SharePanelContactItem> dataList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/multiSelect/widget/SelectedContactsAvatarList$a;", "", "", "AVATAR_COUNT", "I", "<init>", "()V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.sharepanel.multiSelect.widget.SelectedContactsAvatarList$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40644);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SelectedContactsAvatarList(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return;
        }
        iPatchRedirector.redirect((short) 5, (Object) this, (Object) context);
    }

    private final View a(SharePanelContactItem data, int marginRight) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        SharePanelAvatarView sharePanelAvatarView = new SharePanelAvatarView(context, null, 0, 0, 14, null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = marginRight;
        sharePanelAvatarView.setLayoutParams(layoutParams);
        sharePanelAvatarView.setAvatarSize(this.avatarSize);
        SharePanelAvatarView.setBorder$default(sharePanelAvatarView, this.borderWidth, 0, 2, null);
        sharePanelAvatarView.b(data);
        return sharePanelAvatarView;
    }

    private final View b() {
        View view = this.moreItem;
        if (view == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            int i3 = this.avatarSize;
            frameLayout.setLayoutParams(new LinearLayout.LayoutParams(i3, i3));
            ImageView imageView = new ImageView(frameLayout.getContext());
            int i16 = this.moreImageSize;
            imageView.setLayoutParams(new FrameLayout.LayoutParams(i16, i16, 17));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setImageDrawable(ie0.a.f().o(imageView.getContext(), R.drawable.qui_more, R.color.qui_common_icon_secondary, 1000));
            frameLayout.addView(imageView);
            frameLayout.setBackground(frameLayout.getContext().getResources().getDrawable(R.drawable.qui_common_fill_standard_primary_oval, null));
            this.moreItem = frameLayout;
            return frameLayout;
        }
        return view;
    }

    private final void c() {
        int i3;
        removeAllViews();
        if (this.dataList.isEmpty()) {
            return;
        }
        boolean z16 = true;
        int size = this.dataList.size() - 1;
        if (this.dataList.size() > 3) {
            addView(b());
            size = 2;
        } else {
            z16 = false;
        }
        for (int i16 = size; -1 < i16; i16--) {
            if (i16 == size && !z16) {
                i3 = 0;
            } else {
                i3 = -ViewUtils.dpToPx(3.0f);
            }
            addView(a(this.dataList.get(i16), i3));
        }
    }

    public final void setData(@NotNull List<SharePanelContactItem> newList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) newList);
            return;
        }
        Intrinsics.checkNotNullParameter(newList, "newList");
        this.dataList.clear();
        this.dataList.addAll(newList);
        c();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SelectedContactsAvatarList(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return;
        }
        iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) attributeSet);
    }

    public /* synthetic */ SelectedContactsAvatarList(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SelectedContactsAvatarList(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.avatarSize = ViewUtils.dpToPx(20.0f);
        this.moreImageSize = ViewUtils.dpToPx(12.0f);
        this.borderWidth = ViewUtils.dpToPx(1.0f);
        this.dataList = new ArrayList();
        setOrientation(0);
        setGravity(16);
        setLayoutDirection(1);
    }
}
