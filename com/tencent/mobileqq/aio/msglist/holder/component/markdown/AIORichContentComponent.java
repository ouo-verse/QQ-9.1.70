package com.tencent.mobileqq.aio.msglist.holder.component.markdown;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.text.style.ClickableSpan;
import android.text.style.DynamicDrawableSpan;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.content.res.ResourcesCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.android.androidbypass.Element;
import com.tencent.android.androidbypass.enhance.i;
import com.tencent.android.androidbypass.richui.view.j;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.bypass.nativeinterface.Attribute;
import com.tencent.bypass.nativeinterface.CustomElement;
import com.tencent.bypass.nativeinterface.CustomReplaceElement;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.AIOMsgItemMviUIState;
import com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.markdown.AIOMarkdownMsgItemUIState;
import com.tencent.mobileqq.aio.msglist.holder.component.markdown.a;
import com.tencent.mobileqq.aio.msglist.holder.component.markdown.view.RichBubbleContentViewBinding;
import com.tencent.mobileqq.aio.msglist.holder.d;
import com.tencent.mobileqq.aio.msglist.holder.skin.AIOBubbleSkinInfo;
import com.tencent.mobileqq.aio.msglist.payload.AIOMsgItemPayloadType;
import com.tencent.mobileqq.aio.utils.m;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vas.avatar.NtFaceConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.holder.IMsgItemMviUIState;
import com.tencent.qqnt.aio.markdown.api.IMarkdownFeatureCompatApi;
import com.tencent.qqnt.aio.menu.ad;
import com.tencent.qqnt.aio.menu.af;
import com.tencent.qqnt.aio.menu.ag;
import com.tencent.qqnt.aio.menu.aj;
import com.tencent.qqnt.aio.menu.ap;
import com.tencent.qqnt.aio.menu.u;
import com.tencent.qqnt.aio.utils.ViewUtils;
import com.tencent.qqnt.kernel.nativeinterface.InlineKeyboardElement;
import com.tencent.qqnt.kernel.nativeinterface.MarkdownElement;
import com.tencent.qqnt.kernel.nativeinterface.MarkdownStyle;
import com.tencent.qqnt.markdown.QQMarkdownView;
import com.tencent.qqnt.markdown.api.IMarkdownConfigApi;
import com.tencent.qqnt.rich.k;
import com.tencent.qqnt.rich.n;
import com.tencent.qqnt.rich.o;
import com.tencent.qqnt.rich.p;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ce\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0002ET\u0018\u0000 `2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001aB\u000f\u0012\u0006\u0010]\u001a\u00020\\\u00a2\u0006\u0004\b^\u0010_J\u0016\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u0007H\u0002J\b\u0010\u000f\u001a\u00020\u0007H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0002H\u0002J \u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\u0016\u0010\u001f\u001a\u00020\u00102\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\b\u0010!\u001a\u00020 H\u0002J\u000e\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0002J\b\u0010&\u001a\u00020%H\u0002J\b\u0010'\u001a\u00020\u0010H\u0002J\b\u0010(\u001a\u00020\u0007H\u0002J\b\u0010)\u001a\u00020\u0007H\u0002J\b\u0010*\u001a\u00020\u0007H\u0002J\b\u0010+\u001a\u00020\u0010H\u0002J\b\u0010,\u001a\u00020\u0010H\u0002J\u000e\u0010.\u001a\b\u0012\u0004\u0012\u00020-0\"H\u0016J\b\u00100\u001a\u00020/H\u0016J\b\u00102\u001a\u000201H\u0016J\u0016\u00105\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u000204030\"H\u0016J\u0010\u00107\u001a\u00020\u00072\u0006\u00106\u001a\u000204H\u0016J&\u0010:\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u0002092\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\b\u0010;\u001a\u00020\u0010H\u0016J\u001a\u0010?\u001a\u00020\u00072\u0006\u0010=\u001a\u00020<2\b\u0010>\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010@\u001a\u00020\u0007H\u0016R\u0014\u0010D\u001a\u00020A8\u0002X\u0083\u0004\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0014\u0010H\u001a\u00020E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010L\u001a\u00020I8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010P\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010S\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010W\u001a\u00020T8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0014\u0010[\u001a\u00020X8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bY\u0010Z\u00a8\u0006b"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/AIORichContentComponent;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/BaseContentComponent;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/MarkdownMsgItem;", "Lcom/tencent/qqnt/rich/a;", "", "", "payloads", "", "O1", "e2", "j2", "Lorg/json/JSONArray;", "attrList", "l2", "P1", "m2", "", "R1", "Lcom/tencent/aio/api/runtime/a;", "U1", "Lcom/tencent/mobileqq/aio/msglist/holder/skin/AIOBubbleSkinInfo;", "bubbleInfo", "Lcom/tencent/qqnt/rich/p;", "Y1", "msgItem", "Lcom/tencent/qqnt/rich/o;", "X1", "skinInfo", "", "bubbleType", ICustomDataEditor.NUMBER_PARAM_2, "c2", "Lcom/tencent/android/androidbypass/e;", "Z1", "", "Lcom/tencent/android/androidbypass/parser/api/b;", "W1", "Lst/a;", "V1", "g2", "Q1", "k2", "T1", SemanticAttributes.DbSystemValues.H2, "i2", "Lcom/tencent/qqnt/aio/menu/ui/d;", ICustomDataEditor.STRING_PARAM_1, "Lcom/tencent/qqnt/markdown/QQMarkdownView;", "S1", "Lcom/tencent/mobileqq/aio/msglist/holder/component/b;", "p1", "Ljava/lang/Class;", "Lcom/tencent/qqnt/aio/holder/IMsgItemMviUIState;", "getObserverStates", "state", "g1", "position", "Lcom/tencent/aio/data/msglist/a;", "b1", ExifInterface.LATITUDE_SOUTH, "", "action", "objects", "r0", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/view/RichBubbleContentViewBinding;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/view/RichBubbleContentViewBinding;", "mBinding", "com/tencent/mobileqq/aio/msglist/holder/component/markdown/AIORichContentComponent$g", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/AIORichContentComponent$g;", "msgItemCallback", "Lcom/tencent/qqnt/rich/n;", "D", "Lcom/tencent/qqnt/rich/n;", "mRender", "Lcom/tencent/mobileqq/aio/msg/action/c;", "E", "Lcom/tencent/mobileqq/aio/msg/action/c;", "msgActionView", UserInfo.SEX_FEMALE, "Z", "isActionViewCreated", "com/tencent/mobileqq/aio/msglist/holder/component/markdown/AIORichContentComponent$h", "G", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/AIORichContentComponent$h;", "msgStateChangeListener", "Lcom/tencent/qqnt/markdown/click/d;", "H", "Lcom/tencent/qqnt/markdown/click/d;", "mqqApiClickHandler", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "I", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIORichContentComponent extends BaseContentComponent<MarkdownMsgItem> implements com.tencent.qqnt.rich.a {
    static IPatchRedirector $redirector_;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final g msgItemCallback;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final n mRender;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.aio.msg.action.c msgActionView;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isActionViewCreated;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private h msgStateChangeListener;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.markdown.click.d mqqApiClickHandler;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @SuppressLint({"ClickableViewAccessibility"})
    @NotNull
    private final RichBubbleContentViewBinding mBinding;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/AIORichContentComponent$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.markdown.AIORichContentComponent$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/markdown/AIORichContentComponent$b", "Lcom/tencent/qqnt/markdown/codeblock/g;", "Landroidx/lifecycle/LifecycleOwner;", "b", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b extends com.tencent.qqnt.markdown.codeblock.g {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIORichContentComponent.this);
            }
        }

        @Override // com.tencent.qqnt.markdown.codeblock.g, st.a
        @Nullable
        /* renamed from: b */
        public LifecycleOwner getLifeCycleOwner() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (LifecycleOwner) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            a.i iVar = new a.i(null);
            AIORichContentComponent.this.sendIntent(iVar);
            return iVar.a();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J%\u0010\t\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0096\u0001J&\u0010\u000f\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/markdown/AIORichContentComponent$c", "Lcom/tencent/android/androidbypass/parser/api/b;", "Lcom/tencent/android/androidbypass/parser/api/a;", "", "url", "Lcom/tencent/android/androidbypass/parser/api/d;", "parsedResult", "clickText", "", "a", "Landroid/view/View;", "view", "Landroid/text/style/ClickableSpan;", "clickableSpan", "", "b", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class c implements com.tencent.android.androidbypass.parser.api.b, com.tencent.android.androidbypass.parser.api.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ com.tencent.android.androidbypass.enhance.scheme.matcher.d f190957a;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIORichContentComponent.this);
            } else {
                this.f190957a = new com.tencent.android.androidbypass.enhance.scheme.matcher.d();
            }
        }

        @Override // com.tencent.android.androidbypass.parser.api.a
        public boolean a(@Nullable String url, @NotNull com.tencent.android.androidbypass.parser.api.d parsedResult, @Nullable String clickText) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, this, url, parsedResult, clickText)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(parsedResult, "parsedResult");
            return this.f190957a.a(url, parsedResult, clickText);
        }

        @Override // com.tencent.android.androidbypass.enhance.j
        public void b(@Nullable View view, @Nullable ClickableSpan clickableSpan, @Nullable String url) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, view, clickableSpan, url);
            } else if (!FastClickUtils.isFastDoubleClick("AIORichContentComponent") && url != null) {
                AIORichContentComponent aIORichContentComponent = AIORichContentComponent.this;
                aIORichContentComponent.sendIntent(new a.e(url, AIORichContentComponent.J1(aIORichContentComponent)));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J%\u0010\t\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0096\u0001J&\u0010\u000f\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/markdown/AIORichContentComponent$d", "Lcom/tencent/android/androidbypass/parser/api/b;", "Lcom/tencent/android/androidbypass/parser/api/a;", "", "url", "Lcom/tencent/android/androidbypass/parser/api/d;", "parsedResult", "clickText", "", "a", "Landroid/view/View;", "view", "Landroid/text/style/ClickableSpan;", "clickableSpan", "", "b", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class d implements com.tencent.android.androidbypass.parser.api.b, com.tencent.android.androidbypass.parser.api.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ com.tencent.android.androidbypass.enhance.scheme.matcher.a f190959a;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f190959a = new com.tencent.android.androidbypass.enhance.scheme.matcher.a();
            }
        }

        @Override // com.tencent.android.androidbypass.parser.api.a
        public boolean a(@Nullable String url, @NotNull com.tencent.android.androidbypass.parser.api.d parsedResult, @Nullable String clickText) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, this, url, parsedResult, clickText)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(parsedResult, "parsedResult");
            return this.f190959a.a(url, parsedResult, clickText);
        }

        @Override // com.tencent.android.androidbypass.enhance.j
        public void b(@Nullable View view, @Nullable ClickableSpan clickableSpan, @Nullable String url) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, view, clickableSpan, url);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/markdown/AIORichContentComponent$e", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "v", "", "onViewAttachedToWindow", "onViewDetachedFromWindow", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class e implements View.OnAttachStateChangeListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIORichContentComponent.this);
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(@NotNull View v3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) v3);
            } else {
                Intrinsics.checkNotNullParameter(v3, "v");
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(@NotNull View v3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) v3);
                return;
            }
            Intrinsics.checkNotNullParameter(v3, "v");
            if (AIORichContentComponent.this.w1() && com.tencent.qqnt.aio.msg.d.M(AIORichContentComponent.J1(AIORichContentComponent.this))) {
                AIORichContentComponent.this.mRender.d("reset_stream_animtor", null);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/markdown/AIORichContentComponent$f", "Lcom/tencent/android/androidbypass/richui/view/j;", "Landroid/view/View;", "view", "", "viewId", ZPlanPublishSource.FROM_SCHEME, "", NodeProps.ON_CLICK, "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class f implements j {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIORichContentComponent.this);
            }
        }

        @Override // com.tencent.android.androidbypass.richui.view.j
        public void onClick(@NotNull View view, @NotNull String viewId, @NotNull String scheme) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, view, viewId, scheme);
                return;
            }
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(viewId, "viewId");
            Intrinsics.checkNotNullParameter(scheme, "scheme");
            if (QLog.isDevelopLevel()) {
                QLog.i("AIORichContentComponent", 4, "[onMorphisClick]: viewId=" + viewId + ", scheme=" + scheme);
            }
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
            copyOnWriteArrayList.addAllAbsent(AIORichContentComponent.this.W1());
            Unit unit = null;
            com.tencent.android.androidbypass.enhance.j a16 = new com.tencent.android.androidbypass.parser.api.c(copyOnWriteArrayList).a(scheme, "test", null);
            if (a16 != null) {
                a16.b(view, null, scheme);
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                QLog.i("AIORichContentComponent", 1, "[onMorphisClick]: not match handler");
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/markdown/AIORichContentComponent$g", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/span/mini/a;", "", "b", "", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class g implements com.tencent.mobileqq.aio.msglist.holder.component.markdown.span.mini.a {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIORichContentComponent.this);
            }
        }

        @Override // com.tencent.mobileqq.aio.msglist.holder.component.markdown.span.mini.a
        @NotNull
        public String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            if (com.tencent.qqnt.aio.msg.d.j(AIORichContentComponent.J1(AIORichContentComponent.this))) {
                return "1";
            }
            return "0";
        }

        @Override // com.tencent.mobileqq.aio.msglist.holder.component.markdown.span.mini.a
        public boolean b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return AIORichContentComponent.J1(AIORichContentComponent.this).D2();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/markdown/AIORichContentComponent$h", "Lcom/tencent/qqnt/aio/markdown/c;", "Lcom/tencent/qqnt/aio/markdown/d;", "data", "", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class h implements com.tencent.qqnt.aio.markdown.c {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIORichContentComponent.this);
            }
        }

        @Override // com.tencent.qqnt.aio.markdown.c
        public void a(@NotNull com.tencent.qqnt.aio.markdown.d data) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) data);
            } else {
                Intrinsics.checkNotNullParameter(data, "data");
                AIORichContentComponent.this.l2(data.a());
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61208);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIORichContentComponent(@NotNull Context context) {
        ArrayList arrayListOf;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        RichBubbleContentViewBinding richBubbleContentViewBinding = new RichBubbleContentViewBinding(context);
        richBubbleContentViewBinding.getMRv().addOnAttachStateChangeListener(new e());
        richBubbleContentViewBinding.getMRv().setOnInterceptTouchListener(new Function1<MotionEvent, Boolean>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.markdown.AIORichContentComponent$mBinding$1$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIORichContentComponent.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull MotionEvent event) {
                boolean h26;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Boolean) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) event);
                }
                Intrinsics.checkNotNullParameter(event, "event");
                if (event.getAction() == 0) {
                    h26 = AIORichContentComponent.this.h2();
                    if (h26) {
                        return Boolean.TRUE;
                    }
                    if (com.tencent.qqnt.aio.msg.d.g(AIORichContentComponent.J1(AIORichContentComponent.this)) == 1 && AIORichContentComponent.J1(AIORichContentComponent.this).I()) {
                        return Boolean.TRUE;
                    }
                }
                return Boolean.FALSE;
            }
        });
        this.mBinding = richBubbleContentViewBinding;
        g gVar = new g();
        this.msgItemCallback = gVar;
        QQMarkdownView mRv = richBubbleContentViewBinding.getMRv();
        com.tencent.mobileqq.aio.msglist.holder.component.markdown.e eVar = new com.tencent.mobileqq.aio.msglist.holder.component.markdown.e();
        com.tencent.android.androidbypass.e Z1 = Z1();
        List<com.tencent.android.androidbypass.parser.api.b> W1 = W1();
        st.a V1 = V1();
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new com.tencent.mobileqq.aio.msglist.holder.component.markdown.span.recommend.c(), new com.tencent.mobileqq.aio.msglist.holder.component.markdown.span.mini.c(gVar), new com.tencent.mobileqq.aio.msglist.holder.component.markdown.span.story.b(gVar));
        n nVar = new n(context, mRv, eVar, this, new k(new com.tencent.qqnt.rich.g(Z1, W1, V1, arrayListOf, null, 16, null), new com.tencent.qqnt.rich.h(new f(), null, 2, null)));
        i a16 = nVar.a();
        if (a16 != null) {
            a16.f72209y = 0.875f;
            a16.f72205u = com.tencent.qqnt.rich.util.a.f362055a.a(context.getColor(R.color.qui_common_text_primary), 0.68f);
            a16.f72206v = context.getColor(R.color.qui_common_border_standard);
            a16.f72180c = 8.0f;
            a16.f72184e = 16.0f;
            a16.Z = 8.0f;
            a16.U = 16.0f;
            a16.B = 2;
            a16.C = 1;
        }
        this.mRender = nVar;
        this.msgStateChangeListener = new h();
        this.mqqApiClickHandler = new com.tencent.qqnt.markdown.click.d();
    }

    public static final /* synthetic */ MarkdownMsgItem J1(AIORichContentComponent aIORichContentComponent) {
        return aIORichContentComponent.q1();
    }

    private final void O1(List<Object> payloads) {
        if (q1().E2() || com.tencent.qqnt.aio.msg.d.a(q1()) == null) {
            return;
        }
        e2();
        com.tencent.mobileqq.aio.msg.action.c cVar = this.msgActionView;
        if (cVar != null) {
            if (cVar.a(q1(), payloads)) {
                this.mBinding.z(cVar.getRoot(), cVar.getMinWidth());
            } else {
                this.mBinding.r(cVar.getRoot());
            }
        }
    }

    private final void P1() {
        InlineKeyboardElement p26;
        MarkdownElement r26 = q1().r2();
        boolean z16 = true;
        QLog.i("AIORichContentComponent", 1, "[bindInternal]: msgId=" + q1().getMsgId() + " seq=" + q1().getMsgSeq() + " length=" + r26.content.length());
        m2();
        this.mBinding.u(q1().C2());
        this.mBinding.y(i2());
        this.mBinding.w(q1().F2());
        if (g2()) {
            p26 = null;
        } else {
            p26 = q1().p2();
        }
        AIOBubbleSkinInfo x06 = q1().x0();
        if (x06 == null) {
            x06 = com.tencent.mobileqq.aio.utils.n.f194168a.f(getMContext(), q1());
        }
        n2(q1(), x06, q1().m2());
        RichBubbleContentViewBinding richBubbleContentViewBinding = this.mBinding;
        int i3 = 0;
        if (p26 == null) {
            z16 = false;
        }
        richBubbleContentViewBinding.v(z16);
        if (q1().E2()) {
            Q1();
            return;
        }
        if (q1().I2()) {
            if (QLog.isDevelopLevel()) {
                QLog.i("AIORichContentComponent", 4, "[bind]: showProcessView, msg=" + q1().w2());
            }
            if (com.tencent.qqnt.aio.msg.d.g(q1()) == 3 || com.tencent.qqnt.aio.msg.d.g(q1()) == 6) {
                i3 = 2;
            }
            this.mBinding.A(q1().w2(), i3);
            this.mBinding.C();
            return;
        }
        if (R1()) {
            if (QLog.isDevelopLevel()) {
                QLog.i("AIORichContentComponent", 4, "[bind]: data is invalid");
            }
        } else {
            this.mBinding.C();
            this.mBinding.s();
            this.mBinding.getMRv().removeAllViews();
            this.mRender.c(new com.tencent.qqnt.rich.j(new com.tencent.qqnt.rich.c(q1().t2(), q1().u2()), X1(q1()), this.mBinding.m(), Y1(x06), new com.tencent.qqnt.rich.e(q1(), U1())));
            q1().b(false);
            q1().h(false);
        }
    }

    private final void Q1() {
        k2();
        this.mBinding.B();
    }

    private final boolean R1() {
        Object firstOrNull;
        String str;
        CustomElement customElement;
        CustomReplaceElement replaceElement;
        for (com.tencent.android.androidbypass.viewgroup.b bVar : q1().t2()) {
            if (bVar.b() == 3) {
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) bVar.a());
                Element element = (Element) firstOrNull;
                if (element != null) {
                    Attribute attribute = element.getAttributes().get(Element.CUSTOM_ELEMENT);
                    if (attribute == null || (customElement = attribute.getCustomElement()) == null || (replaceElement = customElement.getReplaceElement()) == null || (str = replaceElement.getReplaceNodeId()) == null) {
                        str = "";
                    }
                    Intrinsics.checkNotNullExpressionValue(str, "it.attributes.get(\"custo\u2026ment?.replaceNodeId ?: \"\"");
                    if (q1().u2().containsKey(str)) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    private final void T1() {
        q1().b(false);
        q1().h(false);
        this.mRender.d("stop_stream", null);
        sendIntent(new a.l(q1(), false));
    }

    private final com.tencent.aio.api.runtime.a U1() {
        d.h hVar = new d.h(new d.e(null, 1, null));
        sendIntent(hVar);
        return hVar.a().a();
    }

    private final st.a V1() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<com.tencent.android.androidbypass.parser.api.b> W1() {
        List<com.tencent.android.androidbypass.parser.api.b> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.android.androidbypass.parser.api.b[]{new c(), new d(), new com.tencent.qqnt.markdown.click.c(), this.mqqApiClickHandler});
        return listOf;
    }

    private final o X1(MarkdownMsgItem msgItem) {
        if (!com.tencent.qqnt.aio.msg.d.M(msgItem)) {
            return new o(false, false, 0, 4, null);
        }
        if (msgItem.H2()) {
            QLog.d("AIORichContentComponent", 1, "start new animator seq=" + msgItem.getMsgSeq());
            msgItem.b(false);
            return new o(true, true, com.tencent.qqnt.aio.msg.d.g(msgItem));
        }
        if (msgItem.G2() && com.tencent.qqnt.aio.msg.d.g(msgItem) != 3 && msgItem.I()) {
            boolean h26 = h2();
            QLog.d("AIORichContentComponent", 1, "continue animator seq=" + msgItem.getMsgSeq() + " needAnim=" + h26);
            return new o(true, h26, com.tencent.qqnt.aio.msg.d.g(msgItem));
        }
        sendIntent(new a.l(q1(), false));
        this.mRender.d("reset_stream_animtor", null);
        return new o(true, false, com.tencent.qqnt.aio.msg.d.g(msgItem));
    }

    private final p Y1(AIOBubbleSkinInfo bubbleInfo) {
        ColorStateList g16;
        int b16;
        ColorStateList e16;
        float f16;
        int h16;
        Integer f17;
        Float e17;
        Integer c16;
        Integer a16;
        p pVar = new p(null, null, 0, 0.0f, 0, 0.0f, 0.0f, 0, 255, null);
        AIOBubbleSkinInfo.c e18 = bubbleInfo.e();
        if (e18 != null && (a16 = e18.a()) != null) {
            ColorStateList valueOf = ColorStateList.valueOf(a16.intValue());
            Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(it)");
            pVar.n(valueOf);
        }
        AIOBubbleSkinInfo.c e19 = bubbleInfo.e();
        if (e19 == null || (g16 = e19.b()) == null) {
            g16 = pVar.g();
        }
        pVar.n(g16);
        AIOBubbleSkinInfo.c e26 = bubbleInfo.e();
        if (e26 != null && (c16 = e26.c()) != null) {
            b16 = c16.intValue();
        } else {
            b16 = pVar.b();
        }
        pVar.j(b16);
        AIOBubbleSkinInfo.c e27 = bubbleInfo.e();
        if (e27 == null || (e16 = e27.d()) == null) {
            e16 = pVar.e();
        }
        pVar.l(e16);
        AIOBubbleSkinInfo.c e28 = bubbleInfo.e();
        if (e28 != null && (e17 = e28.e()) != null) {
            f16 = e17.floatValue();
        } else {
            f16 = pVar.f();
        }
        pVar.m(f16);
        AIOBubbleSkinInfo.c e29 = bubbleInfo.e();
        if (e29 != null && (f17 = e29.f()) != null) {
            h16 = f17.intValue();
        } else {
            h16 = pVar.h();
        }
        pVar.o(h16);
        if (((IMarkdownFeatureCompatApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IMarkdownFeatureCompatApi.class)).shouldUseSimpleBreakStrategy()) {
            pVar.i(0);
        }
        pVar.k(ViewUtils.f352270a.b(2));
        return pVar;
    }

    private final com.tencent.android.androidbypass.e Z1() {
        return (com.tencent.android.androidbypass.e) ((IMarkdownConfigApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IMarkdownConfigApi.class)).getWhitelistedSchemeClickListener(new com.tencent.android.androidbypass.e() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.markdown.b
            @Override // com.tencent.android.androidbypass.e
            public final void a(View view, DynamicDrawableSpan dynamicDrawableSpan, String str) {
                AIORichContentComponent.a2(AIORichContentComponent.this, view, dynamicDrawableSpan, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a2(AIORichContentComponent this$0, View view, DynamicDrawableSpan dynamicDrawableSpan, String str) {
        com.tencent.android.androidbypass.span.a aVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.qqnt.markdown.pic.a aVar2 = com.tencent.qqnt.markdown.pic.a.f359431a;
        boolean z16 = dynamicDrawableSpan instanceof com.tencent.android.androidbypass.span.a;
        com.tencent.android.androidbypass.span.a aVar3 = null;
        if (z16) {
            aVar = (com.tencent.android.androidbypass.span.a) dynamicDrawableSpan;
        } else {
            aVar = null;
        }
        String a16 = aVar2.a(aVar);
        com.tencent.mobileqq.aio.msglist.holder.component.markdown.utils.b bVar = com.tencent.mobileqq.aio.msglist.holder.component.markdown.utils.b.f191112a;
        if (z16) {
            aVar3 = (com.tencent.android.androidbypass.span.a) dynamicDrawableSpan;
        }
        this$0.sendIntent(new a.c(a16, str, bVar.c(aVar3), this$0.q1()));
    }

    private final boolean c2(List<Object> payloads) {
        boolean z16 = false;
        if (payloads.isEmpty()) {
            return false;
        }
        for (Object obj : payloads) {
            if (obj instanceof HashMap) {
                Map map = (Map) obj;
                if (map.get(AIOMsgItemPayloadType.BUBBLE_REFRESH_PAYLOAD) != null) {
                    if (QLog.isDevelopLevel()) {
                        QLog.d("AIORichContentComponent", 4, "[handlePayloadData]: msgId=" + q1().getMsgId());
                    }
                    AIOBubbleSkinInfo x06 = q1().x0();
                    if (x06 != null) {
                        this.mBinding.F(x06, m.f194167a.c(q1()), q1().m2());
                    }
                }
                if (map.get(AIOMsgItemPayloadType.ADELIE_MSG_PUSH_STATE_PAYLOAD) != null) {
                    z16 = true;
                }
                if (map.get(AIOMsgItemPayloadType.LAST_RECEIVE_MSG_PAYLOAD) != null && com.tencent.qqnt.aio.msg.d.M(q1()) && !q1().I()) {
                    QLog.d("AIORichContentComponent", 1, "stop stream anim, lastFlag=false seq=" + q1().getMsgSeq());
                    T1();
                }
            }
        }
        return !z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d2(AIORichContentComponent this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mBinding.D();
    }

    private final void e2() {
        if (this.isActionViewCreated) {
            return;
        }
        this.isActionViewCreated = true;
        if (this.msgActionView == null) {
            this.msgActionView = com.tencent.mobileqq.aio.msg.action.d.f190103a.a(U1(), new com.tencent.mobileqq.aio.msg.action.a() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.markdown.d
                @Override // com.tencent.mobileqq.aio.msg.action.a
                public final void a(IMsgItemMviUIState iMsgItemMviUIState) {
                    AIORichContentComponent.f2(AIORichContentComponent.this, iMsgItemMviUIState);
                }
            });
        }
        com.tencent.mobileqq.aio.msg.action.c cVar = this.msgActionView;
        if (cVar != null) {
            cVar.onCreate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f2(AIORichContentComponent this$0, IMsgItemMviUIState it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.handleUIState(it);
    }

    private final boolean g2() {
        a.j jVar = new a.j(false, 1, null);
        sendIntent(jVar);
        return jVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean h2() {
        com.tencent.qqnt.rich.intent.a aVar = new com.tencent.qqnt.rich.intent.a(false, 1, null);
        this.mRender.d("is_stream_anim_start", aVar);
        return aVar.a();
    }

    private final boolean i2() {
        d.l lVar = new d.l(false, 1, null);
        sendIntent(lVar);
        return lVar.a();
    }

    private final void j2() {
        sendIntent(new a.h(this.msgStateChangeListener));
        int i3 = q1().r2().mdExtType;
        if (i3 != 0) {
            sendIntent(new a.g(i3, q1(), this.msgStateChangeListener));
        }
    }

    private final void k2() {
        this.mBinding.getMRv().removeAllViews();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l2(JSONArray attrList) {
        this.mRender.d("rich_update", attrList);
    }

    private final void m2() {
        float[] fArr;
        i a16 = this.mRender.a();
        String str = null;
        if (a16 != null) {
            fArr = a16.f72178b;
        } else {
            fArr = null;
        }
        if (fArr == null) {
            return;
        }
        MarkdownStyle markdownStyle = q1().r2().style;
        if (markdownStyle != null) {
            str = markdownStyle.mainFontSize;
        }
        if (Intrinsics.areEqual(str, NtFaceConstant.SMALL)) {
            ArraysKt___ArraysJvmKt.fill$default(fArr, 16.0f / q1().q2(), 0, 0, 6, (Object) null);
            return;
        }
        float[] a17 = RichBubbleContentViewBinding.INSTANCE.a();
        int length = a17.length;
        int i3 = 0;
        int i16 = 0;
        while (i3 < length) {
            fArr[i16] = a17[i3] / 16.0f;
            i3++;
            i16++;
        }
    }

    private final void n2(MarkdownMsgItem msgItem, AIOBubbleSkinInfo skinInfo, int bubbleType) {
        boolean c16 = m.f194167a.c(msgItem);
        if (c16) {
            AIOBubbleSkinInfo.c e16 = skinInfo.e();
            if (e16 != null) {
                e16.l(2);
                e16.k(Float.valueOf(msgItem.q2()));
                e16.j(ResourcesCompat.getColorStateList(getMContext().getResources(), R.color.qui_common_text_link, null));
            }
        } else {
            AIOBubbleSkinInfo.c e17 = skinInfo.e();
            if (e17 != null) {
                e17.l(2);
                e17.k(Float.valueOf(msgItem.q2()));
            }
        }
        this.mBinding.F(skinInfo, c16, bubbleType);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.qqnt.aio.holder.template.b
    public boolean S() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        if (q1().E2() || h2() || com.tencent.qqnt.aio.msg.d.g(q1()) == 1 || com.tencent.qqnt.aio.msg.d.j(q1()) || q1().C2()) {
            return true;
        }
        return super.S();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    @NotNull
    /* renamed from: S1, reason: merged with bridge method [inline-methods] */
    public QQMarkdownView c1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (QQMarkdownView) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mBinding.getMRv();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.mobileqq.aio.msglist.holder.component.c
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(position), msgItem, payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.b1(position, msgItem, payloads);
        if (QLog.isDevelopLevel()) {
            QLog.i("AIORichContentComponent", 4, "[bind]: msgId=" + q1().getMsgId());
        }
        if (com.tencent.qqnt.aio.msg.d.j(q1()) && c2(payloads)) {
            this.mBinding.D();
            q1().h(false);
            return;
        }
        if ((x1() || c2(payloads)) && z1()) {
            QLog.i("AIORichContentComponent", 1, "[bind] handle payload update, either isSameBindData: " + x1() + ", msgId=" + msgItem.getMsgId() + " seq=" + msgItem.getMsgSeq());
            this.mBinding.D();
            q1().b(false);
            q1().h(false);
            O1(payloads);
            return;
        }
        P1();
        O1(payloads);
        j2();
        if (q1().F2()) {
            this.mqqApiClickHandler.c(q1().getMsgRecord().chatType);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c, com.tencent.mvi.mvvm.BaseVB
    /* renamed from: g1 */
    public void handleUIState(@NotNull IMsgItemMviUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        super.handleUIState(state);
        if (state instanceof AIOMarkdownMsgItemUIState.OnConfigurationChangedUIState) {
            this.mBinding.getMRv().post(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.markdown.c
                @Override // java.lang.Runnable
                public final void run() {
                    AIORichContentComponent.d2(AIORichContentComponent.this);
                }
            });
            return;
        }
        if (state instanceof AIOMarkdownMsgItemUIState.EndStreamAnimUIState) {
            if (w1() && q1().getMsgId() == ((AIOMarkdownMsgItemUIState.EndStreamAnimUIState) state).a()) {
                T1();
                return;
            }
            return;
        }
        if (state instanceof AIOMsgItemMviUIState.OnRegenerateClickUIState) {
            this.mRender.d("rich_clear_cache", null);
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends IMsgItemMviUIState>> getObserverStates() {
        List<Class<? extends IMsgItemMviUIState>> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{AIOMarkdownMsgItemUIState.OnConfigurationChangedUIState.class, AIOMarkdownMsgItemUIState.EndStreamAnimUIState.class});
            return listOf;
        }
        return (List) iPatchRedirector.redirect((short) 5, (Object) this);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        super.onDestroy();
        k2();
        this.mBinding.C();
        this.mRender.d("rich_destory", null);
        if (w1()) {
            E1(MarkdownMsgItem.INSTANCE.a());
        }
        com.tencent.mobileqq.aio.msg.action.c cVar = this.msgActionView;
        if (cVar != null) {
            cVar.onDestroy();
        }
        this.isActionViewCreated = false;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.mobileqq.aio.msglist.holder.component.c
    @NotNull
    /* renamed from: p1 */
    public com.tencent.mobileqq.aio.msglist.holder.component.b createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.mobileqq.aio.msglist.holder.component.b) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new AIOMarkdownContentComponentVM();
    }

    @Override // com.tencent.qqnt.rich.a
    public void r0(@NotNull String action, @Nullable Object objects) {
        com.tencent.qqnt.aio.holder.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) action, objects);
            return;
        }
        Intrinsics.checkNotNullParameter(action, "action");
        int hashCode = action.hashCode();
        if (hashCode != -1194440804) {
            if (hashCode != -1088235805) {
                if (hashCode == -68115606 && action.equals("send_external_message")) {
                    if (objects instanceof com.tencent.qqnt.aio.holder.a) {
                        aVar = (com.tencent.qqnt.aio.holder.a) objects;
                    } else {
                        aVar = null;
                    }
                    if (aVar != null) {
                        sendIntent(aVar);
                        return;
                    }
                    return;
                }
                return;
            }
            if (action.equals("stream_start")) {
                sendIntent(new a.l(q1(), true));
                return;
            }
            return;
        }
        if (action.equals("stream_end")) {
            sendIntent(new a.l(q1(), false));
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent
    @NotNull
    public List<com.tencent.qqnt.aio.menu.ui.d> s1() {
        List listOf;
        boolean z16;
        List listOf2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        boolean z17 = false;
        if (!com.tencent.mobileqq.aio.utils.d.R(q1())) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.qqnt.aio.menu.ui.d[]{new com.tencent.mobileqq.aio.msglist.holder.component.markdown.f(getMContext(), q1()), new com.tencent.qqnt.aio.menu.k(getMContext(), q1(), this, null, 8, null), new ap(getMContext(), q1(), this), new af(getMContext(), q1(), this), new com.tencent.qqnt.aio.menu.h(getMContext(), q1(), this), new u(getMContext(), q1(), this), new ad(getMContext(), q1(), this), new ag(getMContext(), q1()), new aj(getMContext(), q1(), this)});
            arrayList.addAll(listOf);
            if (q1().getMsgRecord().chatType == 2 || q1().getMsgRecord().chatType == 1) {
                String b16 = m.f194167a.b(q1());
                if (b16.length() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16 && !Intrinsics.areEqual(b16, "0")) {
                    z17 = true;
                }
                if (z17) {
                    arrayList.add(new com.tencent.qqnt.aio.menu.n(getMContext(), q1(), this));
                }
            }
            return arrayList;
        }
        if (q1().P2()) {
            arrayList.add(new com.tencent.qqnt.aio.menu.k(getMContext(), q1(), this, null, 8, null));
        }
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.qqnt.aio.menu.ui.d[]{new af(getMContext(), q1(), this), new ad(getMContext(), q1(), this), new com.tencent.qqnt.aio.menu.h(getMContext(), q1(), this), new aj(getMContext(), q1(), this)});
        arrayList.addAll(listOf2);
        return arrayList;
    }
}
