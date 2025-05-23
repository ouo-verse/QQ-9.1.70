package com.tencent.qqnt.richui;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqnt.avatar.meta.b;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b \u0010!J2\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\fH\u0016J\u0016\u0010\u0011\u001a\u00020\u00102\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\bH\u0016J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\bH\u0016R\u0016\u0010\u0014\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R0\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\u001bj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0004`\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u001dR\u0016\u0010\u0012\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0017\u00a8\u0006\""}, d2 = {"Lcom/tencent/qqnt/richui/c;", "Lcom/tencent/android/androidbypass/richui/view/f;", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "cache", "", "avatarId", "", "leftMargin", "avatarSize", "j", "Landroid/widget/FrameLayout;", "k", "", "avatarIdList", "", "g", "allWidth", "d", "space", "f", "b", "I", "c", "Landroid/widget/FrameLayout;", "headLayout", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "avatarViewList", "e", "<init>", "(Landroid/content/Context;)V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class c implements com.tencent.android.androidbypass.richui.view.f {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int space;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final FrameLayout headLayout;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final HashMap<String, QQProAvatarView> avatarViewList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int allWidth;

    public c(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.headLayout = new FrameLayout(context);
        this.avatarViewList = new HashMap<>();
    }

    @Override // com.tencent.android.androidbypass.richui.view.f
    public void d(int allWidth) {
        this.allWidth = allWidth;
    }

    @Override // com.tencent.android.androidbypass.richui.view.f
    public void g(List<String> avatarIdList) {
        Intrinsics.checkNotNullParameter(avatarIdList, "avatarIdList");
        this.headLayout.removeAllViews();
        int size = avatarIdList.size();
        int i3 = this.allWidth;
        int i16 = this.space;
        int i17 = size - 1;
        int i18 = (i3 - (i16 * i17)) / size;
        int max = Math.max((i3 - ((size * i18) + (i16 * i17))) / 2, 0);
        while (-1 < i17) {
            String str = avatarIdList.get(i17);
            int i19 = ((this.space + i18) * i17) + max;
            QQProAvatarView qQProAvatarView = this.avatarViewList.get(String.valueOf(i17));
            Context context = this.headLayout.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "headLayout.context");
            QQProAvatarView j3 = j(context, qQProAvatarView, str, i19, i18);
            if (!this.avatarViewList.containsKey(String.valueOf(i17))) {
                this.avatarViewList.put(String.valueOf(i17), j3);
            }
            this.headLayout.addView(j3);
            i17--;
        }
    }

    @Override // com.tencent.android.androidbypass.richui.view.h
    /* renamed from: k, reason: from getter and merged with bridge method [inline-methods] */
    public FrameLayout getTextView() {
        return this.headLayout;
    }

    @Override // com.tencent.android.androidbypass.richui.view.f
    public void f(int space) {
        this.space = ViewUtils.dpToPx(space);
    }

    private final QQProAvatarView j(Context context, QQProAvatarView cache, String avatarId, int leftMargin, int avatarSize) {
        if (cache == null) {
            cache = new QQProAvatarView(context, (AttributeSet) null, 2, (DefaultConstructorMarker) (0 == true ? 1 : 0));
        }
        int dpToPx = ViewUtils.dpToPx(1.0f);
        cache.setPadding(dpToPx, dpToPx, dpToPx, dpToPx);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(-1);
        cache.setBackground(gradientDrawable);
        cache.A(new b.a(1, avatarId, 140, true).b());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(avatarSize, avatarSize);
        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = leftMargin;
        cache.setLayoutParams(layoutParams);
        return cache;
    }
}
