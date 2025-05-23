package com.tencent.mobileqq.guild.mainframe.create;

import android.graphics.Rect;
import android.util.Log;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewParent;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.RichTextHelper;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.cb;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.widget.inputview.QUISingleLineInputView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u001dB\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ@\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007J\u0012\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0007J\u0012\u0010\u0015\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0007J\u001a\u0010\u001a\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0007\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/create/j;", "", "Landroid/widget/TextView;", "textView", "", "contentId", "urlContentId", "", "url", "Lcom/tencent/mobileqq/guild/mainframe/create/j$a;", "reportClickParams", "Landroid/view/View$OnClickListener;", "onClickListener", "", "f", "Lcom/tencent/mobileqq/widget/inputview/QUISingleLineInputView;", "inputView", "", "c", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProSecurityResult;", "security", "i", "Landroid/view/View;", "view", "Landroid/graphics/Rect;", "hitRect", "d", "<init>", "()V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class j {

    /* renamed from: a */
    @NotNull
    public static final j f227385a = new j();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/create/j$a;", "", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final /* data */ class a {
    }

    j() {
    }

    @JvmStatic
    public static final boolean c(@Nullable QUISingleLineInputView inputView) {
        CharSequence charSequence;
        CharSequence trim;
        String str;
        if (inputView != null) {
            charSequence = inputView.d();
        } else {
            charSequence = null;
        }
        if (charSequence == null) {
            return false;
        }
        String valueOf = String.valueOf(inputView.d());
        long currentTimeMillis = System.currentTimeMillis();
        trim = StringsKt__StringsKt.trim((CharSequence) valueOf);
        cb.b b16 = cb.b(trim.toString());
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("GuildCreateUtils", "[dealEditTextSpace] countEmojiText " + (System.currentTimeMillis() - currentTimeMillis));
        }
        if (b16.c() < 1) {
            str = QQGuildUIUtil.r(R.string.f1508015z);
            Intrinsics.checkNotNullExpressionValue(str, "getString(R.string.guild_name_role_min_length)");
        } else {
            str = "";
        }
        inputView.y(str);
        if (str.length() != 0) {
            return false;
        }
        return true;
    }

    @JvmStatic
    public static final void d(@Nullable final View view, @NotNull final Rect hitRect) {
        ViewParent viewParent;
        Intrinsics.checkNotNullParameter(hitRect, "hitRect");
        final View view2 = null;
        if (view != null) {
            viewParent = view.getParent();
        } else {
            viewParent = null;
        }
        if (viewParent instanceof View) {
            view2 = (View) viewParent;
        }
        if (view2 == null) {
            return;
        }
        view2.post(new Runnable() { // from class: com.tencent.mobileqq.guild.mainframe.create.i
            @Override // java.lang.Runnable
            public final void run() {
                j.e(view, hitRect, view2);
            }
        });
    }

    public static final void e(View view, Rect hitRect, View touchViewParent) {
        Intrinsics.checkNotNullParameter(hitRect, "$hitRect");
        Intrinsics.checkNotNullParameter(touchViewParent, "$touchViewParent");
        Rect rect = new Rect();
        view.getHitRect(rect);
        rect.top -= hitRect.top;
        rect.bottom += hitRect.bottom;
        rect.left -= hitRect.left;
        rect.right += hitRect.right;
        touchViewParent.setTouchDelegate(new TouchDelegate(rect, view));
    }

    @JvmStatic
    public static final void f(@NotNull TextView textView, int contentId, int urlContentId, @NotNull String url, @Nullable a reportClickParams, @Nullable View.OnClickListener onClickListener) {
        boolean z16;
        RichTextHelper.RichTextData richTextData;
        ArrayList arrayListOf;
        Intrinsics.checkNotNullParameter(textView, "textView");
        Intrinsics.checkNotNullParameter(url, "url");
        View.OnClickListener onClickListener2 = new View.OnClickListener(reportClickParams, new WeakReference(onClickListener), url) { // from class: com.tencent.mobileqq.guild.mainframe.create.h

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ WeakReference f227380e;

            /* renamed from: f, reason: collision with root package name */
            public final /* synthetic */ String f227381f;

            {
                this.f227380e = r3;
                this.f227381f = url;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                j.h(WeakReference.this, null, this.f227380e, this.f227381f, view);
            }
        };
        RichTextHelper.RichTextData[] richTextDataArr = new RichTextHelper.RichTextData[1];
        if (url.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            richTextData = new RichTextHelper.RichTextData(QQGuildUIUtil.r(urlContentId), url, onClickListener2);
        } else {
            richTextData = new RichTextHelper.RichTextData(QQGuildUIUtil.r(urlContentId), onClickListener2, true);
        }
        richTextDataArr[0] = richTextData;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(richTextDataArr);
        textView.setText(RichTextHelper.buildSpannable(QQGuildUIUtil.r(contentId), textView.getContext(), false, arrayListOf));
        textView.setMovementMethod(RichTextHelper.getMovementMethodInstance());
        textView.setHighlightColor(0);
    }

    public static /* synthetic */ void g(TextView textView, int i3, int i16, String str, a aVar, View.OnClickListener onClickListener, int i17, Object obj) {
        a aVar2;
        View.OnClickListener onClickListener2;
        if ((i17 & 16) != 0) {
            aVar2 = null;
        } else {
            aVar2 = aVar;
        }
        if ((i17 & 32) != 0) {
            onClickListener2 = null;
        } else {
            onClickListener2 = onClickListener;
        }
        f(textView, i3, i16, str, aVar2, onClickListener2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void h(WeakReference viewWeakRef, a aVar, WeakReference weakRef, String url, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(viewWeakRef, "$viewWeakRef");
        Intrinsics.checkNotNullParameter(weakRef, "$weakRef");
        Intrinsics.checkNotNullParameter(url, "$url");
        TextView textView = (TextView) viewWeakRef.get();
        if (textView == null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "[initRichUrlSpannable] reportView null " + url;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("GuildCreateUtils", 1, (String) it.next(), null);
            }
        } else {
            View.OnClickListener onClickListener = (View.OnClickListener) weakRef.get();
            if (onClickListener != null) {
                onClickListener.onClick(textView);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @JvmStatic
    public static final boolean i(@Nullable IGProSecurityResult security) {
        if (security != null && ((int) security.get$actionCode()) != 0 && ((int) security.get$actionCode()) != 4) {
            return false;
        }
        return true;
    }
}
