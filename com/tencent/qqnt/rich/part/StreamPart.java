package com.tencent.qqnt.rich.part;

import android.animation.Animator;
import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.rich.j;
import com.tencent.qqnt.rich.k;
import com.tencent.qqnt.rich.l;
import com.tencent.qqnt.rich.m;
import com.tencent.qqnt.rich.stream.c;
import com.tencent.qqnt.rich.stream.d;
import com.tencent.qqnt.rich.stream.e;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000\u008b\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u00014\u0018\u0000 B2\u00020\u0001:\u0001\u001fB'\u0012\u0006\u00109\u001a\u000208\u0012\u0006\u0010;\u001a\u00020:\u0012\u0006\u0010=\u001a\u00020<\u0012\u0006\u0010?\u001a\u00020>\u00a2\u0006\u0004\b@\u0010AJ*\u0010\t\u001a\u00020\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005H\u0002J&\u0010\u000e\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002J4\u0010\u0017\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u000bH\u0002J\b\u0010\u0018\u001a\u00020\bH\u0002J\u0012\u0010\u0019\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010\u001a\u001a\u00020\bH\u0002J\u0018\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u001a\u0010$\u001a\u00020\b2\u0006\u0010!\u001a\u00020 2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016R\u0016\u0010&\u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u001b\u0010.\u001a\u00020+8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010,\u001a\u0004\b(\u0010-R\u0016\u00101\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00103\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00100R\u0014\u00107\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106\u00a8\u0006C"}, d2 = {"Lcom/tencent/qqnt/rich/part/StreamPart;", "Lcom/tencent/qqnt/rich/part/a;", "", "Lcom/tencent/android/androidbypass/viewgroup/render/a;", "renderResult", "", "updateStreamData", "fromAnimEnd", "", "j", "renderResultList", "", "curIndex", "curAnimLength", h.F, "Landroid/widget/TextView;", "textView", "Landroid/animation/Animator;", "animation", "", "originContent", "streamContent", "endIndex", DomainData.DOMAIN_NAME, "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", "Landroidx/constraintlayout/widget/ConstraintLayout;", ParseCommon.CONTAINER, "Lcom/tencent/qqnt/rich/j;", "richData", "a", "", "action", "", "objects", "r0", "Lcom/tencent/qqnt/rich/j;", "mRichData", "Lcom/tencent/qqnt/rich/stream/a;", "i", "Lcom/tencent/qqnt/rich/stream/a;", "mStreamAnimatorAdorn", "Landroid/text/SpannableString;", "Lkotlin/Lazy;", "()Landroid/text/SpannableString;", "mLoadingDot", BdhLogUtil.LogTag.Tag_Conn, "I", "currentAnimGroupLength", "D", "currentAnimGroupIndex", "com/tencent/qqnt/rich/part/StreamPart$b", "E", "Lcom/tencent/qqnt/rich/part/StreamPart$b;", "mStreamAnimatorListener", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/rich/m;", "helper", "Lcom/tencent/qqnt/rich/k;", "extParam", "Lcom/tencent/qqnt/rich/l;", "richFactory", "<init>", "(Landroid/content/Context;Lcom/tencent/qqnt/rich/m;Lcom/tencent/qqnt/rich/k;Lcom/tencent/qqnt/rich/l;)V", UserInfo.SEX_FEMALE, "rich_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class StreamPart extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private int currentAnimGroupLength;

    /* renamed from: D, reason: from kotlin metadata */
    private int currentAnimGroupIndex;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final b mStreamAnimatorListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private j mRichData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.rich.stream.a mStreamAnimatorAdorn;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mLoadingDot;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/rich/part/StreamPart$a;", "", "", "CHAR_ELLIPSIS", "Ljava/lang/String;", "TAG", "<init>", "()V", "rich_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.rich.part.StreamPart$a, reason: from kotlin metadata */
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

    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J4\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016J\u0012\u0010\r\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/qqnt/rich/part/StreamPart$b", "Lcom/tencent/qqnt/rich/stream/d;", "Landroid/widget/TextView;", "textView", "Landroid/animation/Animator;", "animation", "", "originContent", "streamContent", "", "endIndex", "", "a", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "rich_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements d {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) StreamPart.this);
            }
        }

        @Override // com.tencent.qqnt.rich.stream.d
        public void a(@Nullable TextView textView, @Nullable Animator animation, @NotNull CharSequence originContent, @NotNull CharSequence streamContent, int endIndex) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, textView, animation, originContent, streamContent, Integer.valueOf(endIndex));
                return;
            }
            Intrinsics.checkNotNullParameter(originContent, "originContent");
            Intrinsics.checkNotNullParameter(streamContent, "streamContent");
            StreamPart.this.n(textView, animation, originContent, streamContent, endIndex);
        }

        @Override // com.tencent.qqnt.rich.stream.d
        public void onAnimationCancel(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) animation);
            }
        }

        @Override // com.tencent.qqnt.rich.stream.d
        public void onAnimationEnd(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                StreamPart.this.l();
            } else {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            }
        }

        @Override // com.tencent.qqnt.rich.stream.d
        public void onAnimationStart(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                StreamPart.this.m(animation);
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36762);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StreamPart(@NotNull final Context context, @NotNull m helper, @NotNull k extParam, @NotNull l richFactory) {
        super(context, helper, extParam, richFactory);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(helper, "helper");
        Intrinsics.checkNotNullParameter(extParam, "extParam");
        Intrinsics.checkNotNullParameter(richFactory, "richFactory");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<SpannableString>(context) { // from class: com.tencent.qqnt.rich.part.StreamPart$mLoadingDot$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ Context $context;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$context = context;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) context);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final SpannableString invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? e.f362052a.a(this.$context) : (SpannableString) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.mLoadingDot = lazy;
            this.currentAnimGroupLength = -1;
            this.currentAnimGroupIndex = -1;
            this.mStreamAnimatorListener = new b();
            return;
        }
        iPatchRedirector.redirect((short) 1, this, context, helper, extParam, richFactory);
    }

    private final int h(List<com.tencent.android.androidbypass.viewgroup.render.a> renderResultList, int curIndex, int curAnimLength) {
        Object orNull;
        Object obj;
        int i3;
        Object lastOrNull;
        if (curIndex >= 0) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(renderResultList, curIndex);
            com.tencent.android.androidbypass.viewgroup.render.a aVar = (com.tencent.android.androidbypass.viewgroup.render.a) orNull;
            SpannableStringBuilder spannableStringBuilder = null;
            if (aVar != null) {
                obj = aVar.a();
            } else {
                obj = null;
            }
            if (obj instanceof SpannableStringBuilder) {
                spannableStringBuilder = (SpannableStringBuilder) obj;
            }
            int i16 = 0;
            if (spannableStringBuilder != null) {
                i3 = spannableStringBuilder.length();
            } else {
                i3 = 0;
            }
            if (i3 > curAnimLength) {
                return curIndex;
            }
            int size = renderResultList.size();
            for (Object obj2 : renderResultList) {
                int i17 = i16 + 1;
                if (i16 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                com.tencent.android.androidbypass.viewgroup.render.a aVar2 = (com.tencent.android.androidbypass.viewgroup.render.a) obj2;
                if (i16 == size - 1 && (aVar2.b() instanceof TextView)) {
                    return i16;
                }
                if (i16 > curIndex && (aVar2.b() instanceof TextView)) {
                    return i16;
                }
                i16 = i17;
            }
            return -1;
        }
        lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) renderResultList);
        com.tencent.android.androidbypass.viewgroup.render.a aVar3 = (com.tencent.android.androidbypass.viewgroup.render.a) lastOrNull;
        if (aVar3 == null || !(aVar3.b() instanceof TextView)) {
            return -1;
        }
        return renderResultList.size() - 1;
    }

    private final SpannableString i() {
        return (SpannableString) this.mLoadingDot.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void j(List<com.tencent.android.androidbypass.viewgroup.render.a> renderResult, boolean updateStreamData, boolean fromAnimEnd) {
        boolean z16;
        boolean z17;
        boolean z18;
        int i3;
        int i16;
        Object orNull;
        Unit unit;
        com.tencent.qqnt.rich.stream.a aVar = this.mStreamAnimatorAdorn;
        if (aVar != null && aVar.isStarted()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            com.tencent.qqnt.rich.stream.a aVar2 = this.mStreamAnimatorAdorn;
            if (aVar2 != null) {
                aVar2.pause();
            }
            z17 = true;
        } else {
            int h16 = h(renderResult, this.currentAnimGroupIndex, this.currentAnimGroupLength);
            if (h16 >= 0) {
                if (!updateStreamData && ((i3 = this.currentAnimGroupIndex) < 0 || i3 != h16)) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                this.currentAnimGroupIndex = h16;
                if (this.mStreamAnimatorAdorn == null) {
                    this.mStreamAnimatorAdorn = new c(this.mStreamAnimatorListener);
                }
                z18 = true;
                List<com.tencent.android.androidbypass.viewgroup.render.a> list = renderResult;
                for (com.tencent.android.androidbypass.viewgroup.render.a aVar3 : list) {
                    if (fromAnimEnd) {
                        View b16 = aVar3.b();
                        Object a16 = aVar3.a();
                        if ((b16 instanceof TextView) && (a16 instanceof SpannableStringBuilder)) {
                            ((TextView) b16).setText((CharSequence) a16);
                        }
                    }
                    aVar3.b().setVisibility(0);
                }
                if (!z18 && (i16 = this.currentAnimGroupIndex) >= 0) {
                    orNull = CollectionsKt___CollectionsKt.getOrNull(renderResult, i16);
                    com.tencent.android.androidbypass.viewgroup.render.a aVar4 = (com.tencent.android.androidbypass.viewgroup.render.a) orNull;
                    if (aVar4 != null) {
                        View b17 = aVar4.b();
                        Object a17 = aVar4.a();
                        if ((b17 instanceof TextView) && (a17 instanceof SpannableStringBuilder)) {
                            if (z17) {
                                int length = ((SpannableStringBuilder) a17).length();
                                com.tencent.qqnt.rich.stream.a aVar5 = this.mStreamAnimatorAdorn;
                                if (aVar5 != null) {
                                    aVar5.a(length, (TextView) b17, (CharSequence) a17);
                                }
                                if (QLog.isDevelopLevel()) {
                                    QLog.i("StreamPart", 4, "[handleMarkdownAnim]: update stream currentIndex=" + this.currentAnimGroupIndex + ", text is " + a17);
                                }
                            } else {
                                com.tencent.qqnt.rich.stream.a aVar6 = this.mStreamAnimatorAdorn;
                                if (aVar6 != null) {
                                    aVar6.c((TextView) b17, (CharSequence) a17);
                                }
                                QLog.i("StreamPart", 1, "[handleMarkdownAnim]: start stream currentIndex=" + this.currentAnimGroupIndex + " text length=" + ((SpannableStringBuilder) a17).length());
                            }
                            this.currentAnimGroupLength = ((SpannableStringBuilder) a17).length();
                            com.tencent.qqnt.rich.stream.a aVar7 = this.mStreamAnimatorAdorn;
                            if (aVar7 != null) {
                                aVar7.start();
                            }
                            int i17 = 0;
                            for (Object obj : list) {
                                int i18 = i17 + 1;
                                if (i17 < 0) {
                                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                                }
                                com.tencent.android.androidbypass.viewgroup.render.a aVar8 = (com.tencent.android.androidbypass.viewgroup.render.a) obj;
                                if (i17 > this.currentAnimGroupIndex) {
                                    aVar8.b().setVisibility(8);
                                } else {
                                    aVar8.b().setVisibility(0);
                                }
                                i17 = i18;
                            }
                        } else if (QLog.isDevelopLevel()) {
                            QLog.i("StreamPart", 4, "[handleMarkdownAnim]: lastRenderView is not textView. view=" + b17 + " builder=" + a17);
                        }
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                    if (unit == null && QLog.isDevelopLevel()) {
                        QLog.i("StreamPart", 4, "[handleMarkdownAnim]: not find anim text");
                        return;
                    }
                    return;
                }
            }
            z17 = false;
        }
        z18 = z17;
        List<com.tencent.android.androidbypass.viewgroup.render.a> list2 = renderResult;
        while (r4.hasNext()) {
        }
        if (!z18) {
        }
    }

    static /* synthetic */ void k(StreamPart streamPart, List list, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        if ((i3 & 4) != 0) {
            z17 = false;
        }
        streamPart.j(list, z16, z17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l() {
        j jVar = this.mRichData;
        if (jVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRichData");
            jVar = null;
        }
        if (jVar.c().a() != 1) {
            c().d("stream_end", null);
        }
        int i3 = this.currentAnimGroupIndex;
        if (i3 >= 0 && i3 < c().c().size() - 1) {
            QLog.d("StreamPart", 1, "handleStreamAnimEnd currentAnimGroupIndex=" + this.currentAnimGroupIndex + " size=" + (c().c().size() - 1));
            k(this, c().c(), false, true, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(Animator animation) {
        long j3;
        if (animation != null) {
            j3 = animation.getDuration();
        } else {
            j3 = 0;
        }
        if (j3 > 0) {
            c().d("stream_start", null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005c, code lost:
    
        if (r2.c().a() == 1) goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void n(TextView textView, Animator animation, CharSequence originContent, CharSequence streamContent, int endIndex) {
        j jVar = null;
        if (this.currentAnimGroupIndex == c().c().size() - 1 && endIndex == originContent.length()) {
            j jVar2 = this.mRichData;
            if (jVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRichData");
                jVar2 = null;
            }
            if (jVar2.c().a() == 3) {
                streamContent = TextUtils.concat(streamContent, "\u2026");
                Intrinsics.checkNotNullExpressionValue(streamContent, "concat(currText, CHAR_ELLIPSIS)");
                if (textView == null) {
                    textView.setText(streamContent);
                    return;
                }
                return;
            }
        }
        if (endIndex >= originContent.length()) {
            j jVar3 = this.mRichData;
            if (jVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRichData");
            } else {
                jVar = jVar3;
            }
        }
        streamContent = TextUtils.concat(streamContent, i());
        Intrinsics.checkNotNullExpressionValue(streamContent, "concat(currText, mLoadingDot)");
        if (textView == null) {
        }
    }

    private final void o() {
        this.currentAnimGroupIndex = -1;
        com.tencent.qqnt.rich.stream.a aVar = this.mStreamAnimatorAdorn;
        if (aVar != null) {
            aVar.cancel();
        }
        com.tencent.qqnt.rich.stream.a aVar2 = this.mStreamAnimatorAdorn;
        if (aVar2 != null) {
            aVar2.b();
        }
        this.currentAnimGroupLength = -1;
    }

    @Override // com.tencent.qqnt.rich.part.a
    public boolean a(@NotNull ConstraintLayout container, @NotNull j richData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) container, (Object) richData)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(richData, "richData");
        this.mRichData = richData;
        if (!richData.c().c()) {
            return false;
        }
        k(this, c().c(), !richData.c().b(), false, 4, null);
        return richData.c().b();
    }

    @Override // com.tencent.qqnt.rich.part.a, com.tencent.qqnt.rich.a
    public void r0(@NotNull String action, @Nullable Object objects) {
        com.tencent.qqnt.rich.stream.a aVar;
        com.tencent.qqnt.rich.intent.a aVar2;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) action, objects);
            return;
        }
        Intrinsics.checkNotNullParameter(action, "action");
        switch (action.hashCode()) {
            case -1188685609:
                if (action.equals("reset_stream_animtor")) {
                    o();
                    return;
                }
                return;
            case -1132945827:
                if (action.equals("stop_stream") && (aVar = this.mStreamAnimatorAdorn) != null) {
                    aVar.end();
                    return;
                }
                return;
            case -535335170:
                if (action.equals("is_stream_anim_start")) {
                    if (objects instanceof com.tencent.qqnt.rich.intent.a) {
                        aVar2 = (com.tencent.qqnt.rich.intent.a) objects;
                    } else {
                        aVar2 = null;
                    }
                    if (aVar2 != null) {
                        com.tencent.qqnt.rich.stream.a aVar3 = this.mStreamAnimatorAdorn;
                        if (aVar3 != null) {
                            z16 = aVar3.isStarted();
                        } else {
                            z16 = false;
                        }
                        aVar2.b(z16);
                        return;
                    }
                    return;
                }
                return;
            case 478152881:
                if (action.equals("rich_destory")) {
                    o();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
