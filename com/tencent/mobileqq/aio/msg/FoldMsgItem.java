package com.tencent.mobileqq.aio.msg;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.o;
import com.tencent.mobileqq.aio.utils.MixMsgUtils;
import com.tencent.mobileqq.aio.utils.av;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.aio.adapter.api.IQQTextApi;
import com.tencent.qqnt.aio.adapter.api.IRichMediaBrowserApi;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.msg.MsgExtKt;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 \u00102\u00020\u0001:\u0001#B\u000f\u0012\u0006\u0010 \u001a\u00020\f\u00a2\u0006\u0004\b!\u0010\"J\u0014\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0006\u0010\b\u001a\u00020\u0007J\b\u0010\t\u001a\u0004\u0018\u00010\u0005J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\fH\u0016J\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0001H\u0016J\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\b\u0010\u0014\u001a\u00020\u0007H\u0016J\b\u0010\u0015\u001a\u00020\u0007H\u0016R\u001b\u0010\u001a\u001a\u00020\u00018FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001f\u001a\u00020\u001b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006%\u00b2\u0006\f\u0010$\u001a\u00020\u001b8\nX\u008a\u0084\u0002"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/FoldMsgItem;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "Lcom/tencent/mobileqq/aio/msg/o;", "Landroid/content/Context;", "context", "", ICustomDataEditor.NUMBER_PARAM_2, "", "i2", "m2", "", "getViewType", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "targetMsgRecord", "b0", "", "Y0", "newMsgItem", "l", "l2", "e2", "g2", "W0", "Lkotlin/Lazy;", "j2", "()Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "mixRealMsg", "", "X0", "k2", "()Ljava/lang/String;", "multforwardTitle", "msgRecord", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", "a", "picTag", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class FoldMsgItem extends AIOMsgItem {
    static IPatchRedirector $redirector_;

    /* renamed from: Y0, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: W0, reason: from kotlin metadata */
    @NotNull
    private final Lazy mixRealMsg;

    /* renamed from: X0, reason: from kotlin metadata */
    @NotNull
    private final Lazy multforwardTitle;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\f\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u0002\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/FoldMsgItem$a;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "a", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msg.FoldMsgItem$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @Nullable
        public final AIOMsgItem a(@NotNull MsgRecord msgRecord) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (AIOMsgItem) iPatchRedirector.redirect((short) 2, (Object) this, (Object) msgRecord);
            }
            Intrinsics.checkNotNullParameter(msgRecord, "<this>");
            if (msgRecord.msgType == 5 || !com.tencent.mobileqq.aio.utils.d.B(msgRecord) || MsgExtKt.S(msgRecord)) {
                return null;
            }
            return new FoldMsgItem(msgRecord);
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
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0017\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/aio/msg/FoldMsgItem$b", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "", NodeProps.ON_CLICK, "Landroid/text/TextPaint;", "ds", "updateDrawState", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b extends ClickableSpan {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ o f190034d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ o.b f190035e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Context f190036f;

        b(o oVar, o.b bVar, Context context) {
            this.f190034d = oVar;
            this.f190035e = bVar;
            this.f190036f = context;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, oVar, bVar, context);
            }
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) widget);
                return;
            }
            Intrinsics.checkNotNullParameter(widget, "widget");
            AppRuntime appRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
            IRichMediaBrowserApi iRichMediaBrowserApi = (IRichMediaBrowserApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IRichMediaBrowserApi.class);
            AIOMsgItem aIOMsgItem = new AIOMsgItem(this.f190034d.getMsgRecord());
            MsgElement b16 = this.f190035e.b();
            Intrinsics.checkNotNullExpressionValue(appRuntime, "appRuntime");
            IRichMediaBrowserApi.a.a(iRichMediaBrowserApi, appRuntime, this.f190036f, null, aIOMsgItem, b16, false, null, null, false, 452, null);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        @SuppressLint({"UseCompatLoadingForColorStateLists"})
        public void updateDrawState(@NotNull TextPaint ds5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) ds5);
                return;
            }
            Intrinsics.checkNotNullParameter(ds5, "ds");
            ds5.setColor(BaseApplication.getContext().getResources().getColorStateList(R.color.qui_common_text_link).getDefaultColor());
            ds5.setUnderlineText(false);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57173);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FoldMsgItem(@NotNull final MsgRecord msgRecord) {
        super(msgRecord);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<AIOMsgItem>() { // from class: com.tencent.mobileqq.aio.msg.FoldMsgItem$mixRealMsg$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MsgRecord.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final AIOMsgItem invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (AIOMsgItem) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    AIOMsgItem c16 = MixMsgUtils.c(MixMsgUtils.f194090a, MsgRecord.this, false, 2, null);
                    AIOMsgItem.Z0(c16, null, 1, null);
                    return c16;
                }
            });
            this.mixRealMsg = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<String>(this) { // from class: com.tencent.mobileqq.aio.msg.FoldMsgItem$multforwardTitle$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ FoldMsgItem this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.this$0 = this;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MsgRecord.this, (Object) this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    com.tencent.qqnt.structmsg.c a16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    if (com.tencent.mobileqq.aio.utils.d.I(MsgRecord.this)) {
                        ArrayList arrayList = new ArrayList();
                        MsgElement firstTypeElement = this.this$0.getFirstTypeElement(16);
                        if (firstTypeElement == null || (a16 = com.tencent.qqnt.structmsg.b.b(firstTypeElement.multiForwardMsgElement.xmlContent).a()) == null || a16.f362297d.isEmpty()) {
                            return "";
                        }
                        com.tencent.qqnt.structmsg.c d16 = a16.d(0);
                        if (d16 != null) {
                            Intrinsics.checkNotNullExpressionValue(d16, "getNode(0)");
                            int c16 = d16.c();
                            for (int i3 = 0; i3 < c16; i3++) {
                                com.tencent.qqnt.structmsg.c childNode = d16.d(i3);
                                if ("title".equals(childNode.f362295b)) {
                                    Intrinsics.checkNotNullExpressionValue(childNode, "childNode");
                                    arrayList.add(new com.tencent.qqnt.structmsg.element.d(new com.tencent.qqnt.structmsg.element.b(childNode)));
                                } else if ("summary".equals(childNode.f362295b)) {
                                    Intrinsics.checkNotNullExpressionValue(childNode, "childNode");
                                    arrayList.add(new com.tencent.qqnt.structmsg.element.c(new com.tencent.qqnt.structmsg.element.b(childNode)));
                                }
                            }
                        }
                        return arrayList.size() > 0 ? ((com.tencent.qqnt.structmsg.element.a) arrayList.get(0)).c().c() : "";
                    }
                    throw new RuntimeException("this record is not multiforward !!");
                }
            });
            this.multforwardTitle = lazy2;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) msgRecord);
    }

    private final CharSequence n2(o oVar, Context context) {
        Lazy lazy;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        lazy = LazyKt__LazyJVMKt.lazy(FoldMsgItem$preText$picTag$2.INSTANCE);
        int size = oVar.o2().size();
        for (int i3 = 0; i3 < size; i3++) {
            o.b bVar = oVar.o2().get(i3);
            if (bVar.b() != null) {
                spannableStringBuilder.append((CharSequence) o2(lazy));
                spannableStringBuilder.setSpan(new b(oVar, bVar, context), spannableStringBuilder.length() - o2(lazy).length(), spannableStringBuilder.length(), 33);
            } else if (bVar.c() != null) {
                spannableStringBuilder.append(IQQTextApi.a.c((IQQTextApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IQQTextApi.class), com.tencent.mobileqq.aio.msglist.holder.component.text.c.f191997a.a(bVar.c()).toString(), 13, com.tencent.qqnt.emotion.constant.b.b(), null, null, 24, null));
            }
        }
        return spannableStringBuilder;
    }

    private static final String o2(Lazy<String> lazy) {
        return lazy.getValue();
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public void Y0(@Nullable Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) context);
        } else {
            super.Y0(context);
            Y1(com.tencent.mobileqq.aio.utils.n.f194168a.f(context, this));
        }
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    @NotNull
    public AIOMsgItem b0(@NotNull MsgRecord targetMsgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (AIOMsgItem) iPatchRedirector.redirect((short) 8, (Object) this, (Object) targetMsgRecord);
        }
        Intrinsics.checkNotNullParameter(targetMsgRecord, "targetMsgRecord");
        return new FoldMsgItem(targetMsgRecord);
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public boolean e2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public boolean g2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem, com.tencent.aio.data.msglist.a
    public int getViewType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return 70;
    }

    public final boolean i2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return com.tencent.mobileqq.aio.utils.d.b(getMsgRecord());
    }

    @NotNull
    public final AIOMsgItem j2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AIOMsgItem) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return (AIOMsgItem) this.mixRealMsg.getValue();
    }

    @NotNull
    public final String k2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return (String) this.multforwardTitle.getValue();
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public void l(@NotNull AIOMsgItem newMsgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) newMsgItem);
            return;
        }
        Intrinsics.checkNotNullParameter(newMsgItem, "newMsgItem");
        super.l(newMsgItem);
        ((FoldMsgItem) newMsgItem).Y1(x0());
    }

    @NotNull
    public final CharSequence l2(@NotNull Context context) {
        o oVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (CharSequence) iPatchRedirector.redirect((short) 11, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        AIOMsgItem j26 = j2();
        if (j26 instanceof o) {
            oVar = (o) j26;
        } else {
            oVar = null;
        }
        if (oVar != null) {
            return n2(oVar, context);
        }
        return av.f194117a.c(j2());
    }

    @Nullable
    public final CharSequence m2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (CharSequence) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return getMsgRecord().foldingInfo.toast;
    }
}
