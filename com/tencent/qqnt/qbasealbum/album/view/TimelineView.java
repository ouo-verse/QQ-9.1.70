package com.tencent.qqnt.qbasealbum.album.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 52\u00020\u0001:\u0001\u0018B\u0011\b\u0016\u0012\u0006\u0010-\u001a\u00020,\u00a2\u0006\u0004\b.\u0010/B\u001b\b\u0016\u0012\u0006\u0010-\u001a\u00020,\u0012\b\u00101\u001a\u0004\u0018\u000100\u00a2\u0006\u0004\b.\u00102B#\b\u0016\u0012\u0006\u0010-\u001a\u00020,\u0012\b\u00101\u001a\u0004\u0018\u000100\u0012\u0006\u00103\u001a\u00020\u0002\u00a2\u0006\u0004\b.\u00104J\u0018\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u001a\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00070\u0006H\u0002J\u0016\u0010\r\u001a\u00020\f2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tJ\u0006\u0010\u000e\u001a\u00020\fJ\u0006\u0010\u000f\u001a\u00020\fJ\u000e\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0002J \u0010\u0018\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0004\u001a\u00020\u0002J\u000e\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0019R\u0016\u0010\u001d\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u001cR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001eR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u001eR\u0018\u0010$\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010&\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010#R\u001e\u0010(\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010\u001eR\u0016\u0010+\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u00066"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/album/view/TimelineView;", "Landroid/widget/RelativeLayout;", "", "curOffset", "remainViews", "c", "", "Landroid/util/Pair;", "e", "", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "photoList", "", "setPhotoList", "d", "g", "", "isInvisibleAll", "f", "height", "setTimelineHeight", "verticalOffset", "", "text", "a", "", "timeBubbleLoc", "b", "I", "mTimelineHeight", "Ljava/util/List;", "timelineLocRecord", "Landroid/widget/TextView;", "mTimelineViews", tl.h.F, "Landroid/widget/RelativeLayout;", "mTimelineViewLayout", "i", "mTimelineViewBack", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mPhotoList", BdhLogUtil.LogTag.Tag_Conn, "Z", "hasShownTimelineAni", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "D", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class TimelineView extends RelativeLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private boolean hasShownTimelineAni;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mTimelineHeight;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Integer> timelineLocRecord;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<TextView> mTimelineViews;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RelativeLayout mTimelineViewLayout;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RelativeLayout mTimelineViewBack;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private List<LocalMediaInfo> mPhotoList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/album/view/TimelineView$a;", "", "", "SINGLE_TIME_ZONE_VIEW_HEIGHT", UserInfo.SEX_FEMALE, "TIME_ZONE_VIEW_TRUE_HEIGHT", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.qbasealbum.album.view.TimelineView$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32578);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimelineView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.timelineLocRecord = new ArrayList();
        this.mTimelineViews = new ArrayList();
        this.mPhotoList = new ArrayList();
    }

    private final int c(int curOffset, int remainViews) {
        int a16 = com.tencent.qqnt.qbasealbum.ktx.d.a(32.0f);
        int a17 = com.tencent.qqnt.qbasealbum.ktx.d.a(20.0f);
        int i3 = a16 * (remainViews - 1);
        int i16 = curOffset + i3 + a17;
        int i17 = this.mTimelineHeight;
        if (i16 > i17) {
            return i17 - (i3 + a17);
        }
        return curOffset;
    }

    private final List<Pair<Integer, Integer>> e() {
        int c16 = com.tencent.qqnt.qbasealbum.utils.f.f361654a.c(System.currentTimeMillis() / 1000);
        ArrayList arrayList = new ArrayList();
        if (this.mPhotoList == null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        List<LocalMediaInfo> list = this.mPhotoList;
        Intrinsics.checkNotNull(list);
        Iterator<LocalMediaInfo> it = list.iterator();
        int i3 = 0;
        int i16 = 0;
        int i17 = Integer.MAX_VALUE;
        while (it.hasNext()) {
            int i18 = i3 + 1;
            int c17 = com.tencent.qqnt.qbasealbum.utils.f.f361654a.c(it.next().getModifiedDate());
            if (c16 - c17 < 3 && !arrayList2.contains(Integer.valueOf(c17))) {
                arrayList.add(new Pair(Integer.valueOf(i3), Integer.valueOf(c17)));
                arrayList2.add(Integer.valueOf(c17));
            }
            if (c17 != i17) {
                i16 = i3;
            }
            i17 = RangesKt___RangesKt.coerceAtMost(i17, c17);
            i3 = i18;
        }
        if (!arrayList2.contains(Integer.valueOf(i17)) && i17 != Integer.MAX_VALUE) {
            arrayList.add(new Pair(Integer.valueOf(i16), Integer.valueOf(i17)));
            arrayList2.add(Integer.valueOf(i17));
        }
        return arrayList;
    }

    public final void a(int verticalOffset, @Nullable String text, int remainViews) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(verticalOffset), text, Integer.valueOf(remainViews));
            return;
        }
        TextView textView = new TextView(getContext());
        textView.setTextSize(11.0f);
        com.tencent.qqnt.qbasealbum.ktx.d.f(textView, R.color.c_5);
        com.tencent.qqnt.qbasealbum.ktx.d.d(textView, R.drawable.n68);
        int a16 = com.tencent.qqnt.qbasealbum.ktx.d.a(32.0f);
        if (this.timelineLocRecord.size() > 0) {
            List<Integer> list = this.timelineLocRecord;
            if (verticalOffset - list.get(list.size() - 1).intValue() < a16) {
                List<Integer> list2 = this.timelineLocRecord;
                verticalOffset = list2.get(list2.size() - 1).intValue() + a16;
            }
        }
        int c16 = c(verticalOffset, remainViews);
        this.timelineLocRecord.add(Integer.valueOf(c16));
        textView.setY(c16);
        textView.setText(text);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        textView.setGravity(17);
        layoutParams.height = com.tencent.qqnt.qbasealbum.ktx.d.b(20);
        layoutParams.width = com.tencent.qqnt.qbasealbum.ktx.d.b(40);
        layoutParams.rightMargin = com.tencent.qqnt.qbasealbum.ktx.d.b(62);
        layoutParams.addRule(11);
        ViewCompat.setElevation(textView, 6.0f);
        RelativeLayout relativeLayout = this.mTimelineViewLayout;
        if (relativeLayout != null) {
            Intrinsics.checkNotNull(relativeLayout);
            relativeLayout.addView(textView, 0, layoutParams);
        }
        this.mTimelineViews.add(textView);
    }

    public final void b(float timeBubbleLoc) {
        boolean z16;
        boolean z17;
        boolean z18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Float.valueOf(timeBubbleLoc));
            return;
        }
        if (this.timelineLocRecord.size() <= 2) {
            return;
        }
        Iterator<Integer> it = this.timelineLocRecord.iterator();
        float f16 = Float.MAX_VALUE;
        float f17 = Float.MIN_VALUE;
        int i3 = 0;
        int i16 = 0;
        int i17 = 0;
        while (it.hasNext()) {
            int i18 = i3 + 1;
            float intValue = timeBubbleLoc - (it.next().intValue() + com.tencent.qqnt.qbasealbum.ktx.d.a(16.0f));
            f16 = RangesKt___RangesKt.coerceAtMost(Math.abs(intValue), f16);
            if (f16 == Math.abs(intValue)) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                i16 = i3;
            }
            f17 = RangesKt___RangesKt.coerceAtLeast(Math.abs(intValue), f17);
            if (f17 == Math.abs(intValue)) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (z18) {
                i17 = i3;
            }
            i3 = i18;
        }
        if (f17 == f16) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        int size = this.mTimelineViews.size();
        for (int i19 = 0; i19 < size; i19++) {
            if (i19 == i16) {
                this.mTimelineViews.get(i19).setAlpha(1.0f);
            } else if (i19 == i17) {
                this.mTimelineViews.get(i19).setAlpha(0.4f);
            } else {
                TextView textView = this.mTimelineViews.get(i19);
                textView.setAlpha(1 - (((Math.abs(timeBubbleLoc - textView.getY()) - f16) / (f17 - f16)) * 0.6f));
            }
        }
    }

    public final void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        List<LocalMediaInfo> list = this.mPhotoList;
        if (list != null) {
            Intrinsics.checkNotNull(list);
            if (!list.isEmpty()) {
                if (this.mTimelineViewLayout != null) {
                    for (TextView textView : this.mTimelineViews) {
                        RelativeLayout relativeLayout = this.mTimelineViewLayout;
                        Intrinsics.checkNotNull(relativeLayout);
                        relativeLayout.removeView(textView);
                    }
                }
                this.mTimelineViews.clear();
                this.timelineLocRecord.clear();
                this.mTimelineViewLayout = (RelativeLayout) findViewById(R.id.f246609q);
                ViewParent parent = getParent();
                Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.widget.FrameLayout");
                this.mTimelineViewBack = (RelativeLayout) ((FrameLayout) parent).findViewById(R.id.f246509p);
                List<Pair<Integer, Integer>> e16 = e();
                int i3 = 0;
                for (Pair<Integer, Integer> pair : e16) {
                    Integer num = (Integer) pair.first;
                    String valueOf = String.valueOf(pair.second);
                    float intValue = num.intValue();
                    Intrinsics.checkNotNull(this.mPhotoList);
                    a((int) ((intValue / r6.size()) * this.mTimelineHeight), valueOf, e16.size() - i3);
                    i3++;
                }
            }
        }
    }

    public final void f(boolean isInvisibleAll) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, isInvisibleAll);
            return;
        }
        RelativeLayout relativeLayout = this.mTimelineViewLayout;
        if (relativeLayout != null && this.mTimelineViewBack != null) {
            if (isInvisibleAll) {
                Intrinsics.checkNotNull(relativeLayout);
                relativeLayout.setVisibility(4);
                RelativeLayout relativeLayout2 = this.mTimelineViewBack;
                Intrinsics.checkNotNull(relativeLayout2);
                relativeLayout2.setVisibility(4);
            }
            if (this.hasShownTimelineAni) {
                this.hasShownTimelineAni = false;
                RelativeLayout relativeLayout3 = this.mTimelineViewLayout;
                Intrinsics.checkNotNull(relativeLayout3);
                ObjectAnimator.ofFloat(relativeLayout3, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f).setDuration(300L).start();
                RelativeLayout relativeLayout4 = this.mTimelineViewBack;
                Intrinsics.checkNotNull(relativeLayout4);
                ObjectAnimator.ofFloat(relativeLayout4, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f).setDuration(300L).start();
            }
        }
    }

    public final void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        RelativeLayout relativeLayout = this.mTimelineViewLayout;
        if (relativeLayout != null && this.mTimelineViewBack != null) {
            Intrinsics.checkNotNull(relativeLayout);
            relativeLayout.setVisibility(0);
            RelativeLayout relativeLayout2 = this.mTimelineViewBack;
            Intrinsics.checkNotNull(relativeLayout2);
            relativeLayout2.setVisibility(0);
            if (!this.hasShownTimelineAni) {
                this.hasShownTimelineAni = true;
                RelativeLayout relativeLayout3 = this.mTimelineViewLayout;
                Intrinsics.checkNotNull(relativeLayout3);
                ObjectAnimator.ofFloat(relativeLayout3, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f).setDuration(300L).start();
                RelativeLayout relativeLayout4 = this.mTimelineViewBack;
                Intrinsics.checkNotNull(relativeLayout4);
                ObjectAnimator.ofFloat(relativeLayout4, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f).setDuration(300L).start();
            }
        }
    }

    public final void setPhotoList(@Nullable List<LocalMediaInfo> photoList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) photoList);
        } else {
            this.mPhotoList = photoList;
        }
    }

    public final void setTimelineHeight(int height) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, height);
        } else {
            this.mTimelineHeight = height;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimelineView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.timelineLocRecord = new ArrayList();
        this.mTimelineViews = new ArrayList();
        this.mPhotoList = new ArrayList();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimelineView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.timelineLocRecord = new ArrayList();
        this.mTimelineViews = new ArrayList();
        this.mPhotoList = new ArrayList();
    }
}
