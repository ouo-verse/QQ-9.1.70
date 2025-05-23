package com.tencent.mobileqq.guild.feed.video;

import android.view.View;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u0000 %2\u00020\u0001:\u0004=\u0007\u0010\u0017B\u0007\u00a2\u0006\u0004\b;\u0010<J\u001f\u0010\u0007\u001a\u00020\u00062\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\u0002\b\u0004R\"\u0010\u000e\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001a\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R$\u0010!\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001c\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010'\u001a\u00020\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010#\u001a\u0004\b\u0010\u0010$\"\u0004\b%\u0010&R\"\u0010.\u001a\u00020(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u00101\u001a\u00020(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u0010)\u001a\u0004\b\u0017\u0010+\"\u0004\b0\u0010-R0\u00107\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u000202\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u00103\u001a\u0004\b/\u00104\"\u0004\b5\u00106R0\u0010:\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u00103\u001a\u0004\b8\u00104\"\u0004\b9\u00106\u00a8\u0006>"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/video/GuidePopBuilder;", "", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "initFunc", "Lcom/tencent/mobileqq/guild/feed/video/f;", "a", "Lcom/tencent/mobileqq/guild/feed/video/GuidePopBuilder$c;", "Lcom/tencent/mobileqq/guild/feed/video/GuidePopBuilder$c;", tl.h.F, "()Lcom/tencent/mobileqq/guild/feed/video/GuidePopBuilder$c;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Lcom/tencent/mobileqq/guild/feed/video/GuidePopBuilder$c;)V", "posInfo", "", "b", "Ljava/lang/String;", "f", "()Ljava/lang/String;", DomainData.DOMAIN_NAME, "(Ljava/lang/String;)V", "dsc", "c", "e", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "content", "Lcom/tencent/mobileqq/guild/feed/video/GuidePopBuilder$b;", "d", "Lcom/tencent/mobileqq/guild/feed/video/GuidePopBuilder$b;", "()Lcom/tencent/mobileqq/guild/feed/video/GuidePopBuilder$b;", "l", "(Lcom/tencent/mobileqq/guild/feed/video/GuidePopBuilder$b;)V", "clickCallback", "Lcom/tencent/mobileqq/guild/feed/video/GuidePopBuilder$ArrowDirect;", "Lcom/tencent/mobileqq/guild/feed/video/GuidePopBuilder$ArrowDirect;", "()Lcom/tencent/mobileqq/guild/feed/video/GuidePopBuilder$ArrowDirect;", "j", "(Lcom/tencent/mobileqq/guild/feed/video/GuidePopBuilder$ArrowDirect;)V", "arrowDirect", "", "I", "getGap", "()I", "o", "(I)V", "gap", "g", "k", "bubbleMaxWidth", "", "Lkotlin/jvm/functions/Function1;", "()Lkotlin/jvm/functions/Function1;", "p", "(Lkotlin/jvm/functions/Function1;)V", "matchDetector", "i", "r", "transformContent", "<init>", "()V", "ArrowDirect", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuidePopBuilder {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b clickCallback;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<? super String, Boolean> matchDetector;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<? super String, String> transformContent;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private c posInfo = new c(null, 0, 0, 0, 15, null);

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String dsc = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String content = "";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrowDirect arrowDirect = ArrowDirect.OnTop;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int gap = com.tencent.guild.aio.util.c.b(14);

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int bubbleMaxWidth = ScreenUtil.SCREEN_WIDTH;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/video/GuidePopBuilder$ArrowDirect;", "", "(Ljava/lang/String;I)V", "OnTop", "OnBottom", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public enum ArrowDirect {
        OnTop,
        OnBottom
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/video/GuidePopBuilder$b;", "", "", "contentStr", "", "G0", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface b {
        void G0(@NotNull String contentStr);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t\u0012\b\b\u0002\u0010\u0012\u001a\u00020\t\u0012\b\b\u0002\u0010\u0015\u001a\u00020\t\u00a2\u0006\u0004\b\u0016\u0010\u0017R$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\u000f\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\n\u0010\u000eR\"\u0010\u0012\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u000b\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000eR\"\u0010\u0015\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0013\u0010\r\"\u0004\b\u0014\u0010\u000e\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/video/GuidePopBuilder$c;", "", "Landroid/view/View;", "a", "Landroid/view/View;", "()Landroid/view/View;", "c", "(Landroid/view/View;)V", HippyNestedScrollComponent.PRIORITY_PARENT, "", "b", "I", "getGravity", "()I", "(I)V", LayoutAttrDefine.Gravity.Gravity, "getPosX", "d", "posX", "getPosY", "e", "posY", "<init>", "(Landroid/view/View;III)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private View parent;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int gravity;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private int posX;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int posY;

        public c() {
            this(null, 0, 0, 0, 15, null);
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final View getParent() {
            return this.parent;
        }

        public final void b(int i3) {
            this.gravity = i3;
        }

        public final void c(@Nullable View view) {
            this.parent = view;
        }

        public final void d(int i3) {
            this.posX = i3;
        }

        public final void e(int i3) {
            this.posY = i3;
        }

        public c(@Nullable View view, int i3, int i16, int i17) {
            this.parent = view;
            this.gravity = i3;
            this.posX = i16;
            this.posY = i17;
        }

        public /* synthetic */ c(View view, int i3, int i16, int i17, int i18, DefaultConstructorMarker defaultConstructorMarker) {
            this((i18 & 1) != 0 ? null : view, (i18 & 2) != 0 ? 48 : i3, (i18 & 4) != 0 ? 0 : i16, (i18 & 8) != 0 ? 0 : i17);
        }
    }

    @NotNull
    public final f a(@NotNull Function1<? super GuidePopBuilder, Unit> initFunc) {
        Intrinsics.checkNotNullParameter(initFunc, "initFunc");
        initFunc.invoke(this);
        return new g(this);
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final ArrowDirect getArrowDirect() {
        return this.arrowDirect;
    }

    /* renamed from: c, reason: from getter */
    public final int getBubbleMaxWidth() {
        return this.bubbleMaxWidth;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final b getClickCallback() {
        return this.clickCallback;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getDsc() {
        return this.dsc;
    }

    @Nullable
    public final Function1<String, Boolean> g() {
        return this.matchDetector;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final c getPosInfo() {
        return this.posInfo;
    }

    @Nullable
    public final Function1<String, String> i() {
        return this.transformContent;
    }

    public final void j(@NotNull ArrowDirect arrowDirect) {
        Intrinsics.checkNotNullParameter(arrowDirect, "<set-?>");
        this.arrowDirect = arrowDirect;
    }

    public final void k(int i3) {
        this.bubbleMaxWidth = i3;
    }

    public final void l(@Nullable b bVar) {
        this.clickCallback = bVar;
    }

    public final void m(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.content = str;
    }

    public final void n(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.dsc = str;
    }

    public final void o(int i3) {
        this.gap = i3;
    }

    public final void p(@Nullable Function1<? super String, Boolean> function1) {
        this.matchDetector = function1;
    }

    public final void q(@NotNull c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<set-?>");
        this.posInfo = cVar;
    }

    public final void r(@Nullable Function1<? super String, String> function1) {
        this.transformContent = function1;
    }
}
