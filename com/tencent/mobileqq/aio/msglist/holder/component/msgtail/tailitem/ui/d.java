package com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.x;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.emoticon.api.IEmoticonApi;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import com.tencent.qqnt.msg.MsgExtKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u0006\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u001c\u0010\r\u001a\n \n*\u0004\u0018\u00010\t0\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/tailitem/ui/d;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/tailitem/ui/c;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/data/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "o", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "H", "Landroid/widget/TextView;", "tvEmoticonTail", "Lcom/tencent/qqnt/kernel/nativeinterface/PicElement;", "I", "Lcom/tencent/qqnt/kernel/nativeinterface/PicElement;", "picElement", "itemView", "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/ui/e;", "adapter", "<init>", "(Landroid/view/View;Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/ui/e;)V", "J", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class d extends c {
    static IPatchRedirector $redirector_;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: H, reason: from kotlin metadata */
    private final TextView tvEmoticonTail;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private PicElement picElement;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/tailitem/ui/d$a;", "", "Landroid/content/Context;", "context", "Landroid/view/View;", "a", "", "AI_EMO", "I", "", "TAG", "Ljava/lang/String;", "ZPLAN_EMO", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.ui.d$a, reason: from kotlin metadata */
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

        @NotNull
        public final View a(@NotNull Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            }
            Intrinsics.checkNotNullParameter(context, "context");
            TextView textView = new TextView(context);
            textView.setId(R.id.utf);
            textView.setLayoutParams(new ViewGroup.LayoutParams(-2, -1));
            textView.setGravity(17);
            textView.setMaxLines(1);
            int a16 = x.a(7.0f);
            textView.setPadding(a16, 0, a16, 0);
            textView.setIncludeFontPadding(true);
            textView.setTextColor(ContextCompat.getColor(context, R.color.qui_common_text_secondary_light));
            textView.setTextSize(12.0f);
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(0);
            linearLayout.addView(textView);
            return linearLayout;
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62246);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull View itemView, @NotNull com.tencent.mobileqq.aio.msglist.holder.component.msgtail.ui.e adapter) {
        super(itemView, adapter);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView, (Object) adapter);
        } else {
            this.tvEmoticonTail = (TextView) itemView.findViewById(R.id.utf);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.ui.c
    public void o(@NotNull com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.g item) {
        ArrayList<MsgElement> arrayList;
        Object obj;
        PicElement picElement;
        Map mapOf;
        Map mapOf2;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) item);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        MsgRecord a16 = item.a();
        PicElement picElement2 = null;
        if (a16 != null && (arrayList = a16.elements) != null) {
            Iterator<T> it = arrayList.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((MsgElement) obj).elementType == 2) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            MsgElement msgElement = (MsgElement) obj;
            if (msgElement != null && (picElement = msgElement.picElement) != null) {
                if (MsgExtKt.a0(picElement)) {
                    this.tvEmoticonTail.setText(R.string.f242987w2);
                    mapOf2 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("msg_label", 4));
                    com.tencent.mobileqq.aio.utils.b.q("em_msg_label", mapOf2);
                } else if (MsgExtKt.s(picElement)) {
                    this.tvEmoticonTail.setText(R.string.f224386is);
                } else if (MsgExtKt.o(picElement)) {
                    this.tvEmoticonTail.setText(R.string.f208825dr);
                    mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("msg_label", 5));
                    com.tencent.mobileqq.aio.utils.b.q("em_msg_label", mapOf);
                }
                picElement2 = picElement;
            }
        }
        this.picElement = picElement2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        FragmentActivity fragmentActivity;
        PicElement picElement;
        Map mapOf;
        Map mapOf2;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) v3);
        } else {
            Context context = this.itemView.getContext();
            if (context instanceof FragmentActivity) {
                fragmentActivity = (FragmentActivity) context;
            } else {
                fragmentActivity = null;
            }
            if (fragmentActivity != null && (picElement = this.picElement) != null) {
                if (MsgExtKt.a0(picElement)) {
                    ((IEmoticonApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IEmoticonApi.class)).showZPlanEmoticonPanel(fragmentActivity);
                    QLog.i("TailItemHolder-EmoticonTailHolder", 1, "onClick zplan");
                    mapOf2 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("msg_label", 4));
                    com.tencent.mobileqq.aio.utils.b.l("em_msg_label", mapOf2);
                } else if (MsgExtKt.s(picElement)) {
                    ((IEmoticonApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IEmoticonApi.class)).showCompositeEmoticonPanel(fragmentActivity);
                    QLog.i("TailItemHolder-EmoticonTailHolder", 1, "onClick composite");
                } else if (MsgExtKt.o(picElement)) {
                    ((IEmoticonApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IEmoticonApi.class)).showAIEmoticonPanel(fragmentActivity);
                    QLog.i("TailItemHolder-EmoticonTailHolder", 1, "onClick ai");
                    mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("msg_label", 5));
                    com.tencent.mobileqq.aio.utils.b.l("em_msg_label", mapOf);
                }
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }
}
