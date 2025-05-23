package com.tencent.mobileqq.aio.msglist.holder.component.multipci;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.android.androidbypass.parser.a;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.MultiPicMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent;
import com.tencent.mobileqq.aio.msglist.holder.d;
import com.tencent.mobileqq.aio.msglist.payload.AIOMsgItemPayloadType;
import com.tencent.mobileqq.aio.utils.p;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.menu.h;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 F2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001GB\u000f\u0012\u0006\u0010$\u001a\u00020!\u00a2\u0006\u0004\bD\u0010EJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0016\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\bH\u0002J\b\u0010\u000e\u001a\u00020\bH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u0003H\u0016J&\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0016R\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u001b\u0010)\u001a\u00020\u00038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001b\u0010-\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b*\u0010&\u001a\u0004\b+\u0010,R\u001b\u00102\u001a\u00020.8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b/\u0010&\u001a\u0004\b0\u00101R\u001b\u00107\u001a\u0002038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b4\u0010&\u001a\u0004\b5\u00106R\u001b\u0010<\u001a\u0002088BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b9\u0010&\u001a\u0004\b:\u0010;R\u001b\u0010?\u001a\u0002088BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b=\u0010&\u001a\u0004\b>\u0010;R\u0018\u0010C\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010B\u00a8\u0006H"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/multipci/AIOMultiPicContentComponent;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/BaseContentComponent;", "Lcom/tencent/mobileqq/aio/msg/MultiPicMsgItem;", "Landroid/view/View;", "L1", "", "", "payloads", "", "V1", "W1", "c2", "Z1", ICustomDataEditor.STRING_ARRAY_PARAM_2, "X1", "", "Y1", "", "N1", "Lcom/tencent/qqnt/kernel/nativeinterface/FileElement;", "fileElement", "", "T1", "Lcom/tencent/mobileqq/aio/msglist/holder/component/multipci/b;", "M1", "c1", "position", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "b1", "", "Lcom/tencent/qqnt/aio/menu/ui/d;", ICustomDataEditor.STRING_PARAM_1, "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "context", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "P1", "()Landroid/view/View;", "contentView", "D", "U1", "()I", "thumbSize", "Lcom/tencent/android/androidbypass/parser/a;", "E", "Q1", "()Lcom/tencent/android/androidbypass/parser/a;", "mMarkdownParser", "Landroid/widget/RelativeLayout;", UserInfo.SEX_FEMALE, "O1", "()Landroid/widget/RelativeLayout;", ParseCommon.CONTAINER, "Landroid/widget/TextView;", "G", "S1", "()Landroid/widget/TextView;", "picView", "H", "R1", "picCountView", "Landroid/widget/ProgressBar;", "I", "Landroid/widget/ProgressBar;", "progressBar", "<init>", "(Landroid/content/Context;)V", "J", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOMultiPicContentComponent extends BaseContentComponent<MultiPicMsgItem> {
    static IPatchRedirector $redirector_;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy contentView;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy thumbSize;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy mMarkdownParser;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy container;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy picView;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy picCountView;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private ProgressBar progressBar;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/multipci/AIOMultiPicContentComponent$a;", "", "", "BUBBLE_MARGIN", UserInfo.SEX_FEMALE, "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.multipci.AIOMultiPicContentComponent$a, reason: from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62534);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIOMultiPicContentComponent(@NotNull Context context) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.context = context;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.multipci.AIOMultiPicContentComponent$contentView$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOMultiPicContentComponent.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final View invoke() {
                View L1;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (View) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                L1 = AIOMultiPicContentComponent.this.L1();
                return L1;
            }
        });
        this.contentView = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(AIOMultiPicContentComponent$thumbSize$2.INSTANCE);
        this.thumbSize = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(AIOMultiPicContentComponent$mMarkdownParser$2.INSTANCE);
        this.mMarkdownParser = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<RelativeLayout>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.multipci.AIOMultiPicContentComponent$container$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOMultiPicContentComponent.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RelativeLayout invoke() {
                Context context2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (RelativeLayout) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                context2 = AIOMultiPicContentComponent.this.context;
                RelativeLayout relativeLayout = new RelativeLayout(context2);
                relativeLayout.setId(R.id.b8q);
                int b16 = p.b(6.0f);
                relativeLayout.setPadding(b16, b16, b16, b16);
                relativeLayout.setBackgroundResource(R.drawable.qui_aio_input_bg);
                return relativeLayout;
            }
        });
        this.container = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.multipci.AIOMultiPicContentComponent$picView$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOMultiPicContentComponent.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                Context context2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (TextView) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                context2 = AIOMultiPicContentComponent.this.context;
                TextView textView = new TextView(context2);
                textView.setId(R.id.sjj);
                textView.setClickable(false);
                textView.setContentDescription(HardCodeUtil.qqStr(R.string.yp6));
                com.tencent.aio.view_dsl.dsl.f.p(textView, com.tencent.aio.view_dsl.dsl.b.k());
                return textView;
            }
        });
        this.picView = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.multipci.AIOMultiPicContentComponent$picCountView$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOMultiPicContentComponent.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                Context context2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (TextView) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                context2 = AIOMultiPicContentComponent.this.context;
                TextView textView = new TextView(context2);
                textView.setId(R.id.f110656j4);
                textView.setPadding(p.b(8.0f), p.b(4.0f), p.b(8.0f), p.b(4.0f));
                textView.setBackgroundResource(R.drawable.j87);
                textView.setTextColor(ContextCompat.getColor(textView.getContext(), R.color.qui_common_text_white));
                com.tencent.aio.view_dsl.dsl.f.p(textView, com.tencent.aio.view_dsl.dsl.b.j() | com.tencent.aio.view_dsl.dsl.b.k());
                return textView;
            }
        });
        this.picCountView = lazy6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K1(AIOMultiPicContentComponent this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(new d.aa(this$0.q1(), this$0.P1()));
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View L1() {
        RelativeLayout relativeLayout = new RelativeLayout(this.context);
        RelativeLayout O1 = O1();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = ViewUtils.dip2px(6.0f);
        layoutParams.topMargin = ViewUtils.dip2px(6.0f);
        layoutParams.rightMargin = ViewUtils.dip2px(6.0f);
        layoutParams.bottomMargin = ViewUtils.dip2px(6.0f);
        Unit unit = Unit.INSTANCE;
        relativeLayout.addView(O1, layoutParams);
        O1().addView(S1(), new RelativeLayout.LayoutParams(-2, -2));
        RelativeLayout O12 = O1();
        TextView R1 = R1();
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(7, R.id.sjj);
        layoutParams2.addRule(6, R.id.sjj);
        O12.addView(R1, layoutParams2);
        return relativeLayout;
    }

    private final int N1() {
        boolean z16;
        int coerceAtMost;
        ArrayList<MsgElement> arrayList = q1().getMsgRecord().elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "mCurrentMsgItem.msgRecord.elements");
        int i3 = 0;
        if (!(arrayList instanceof Collection) || !arrayList.isEmpty()) {
            Iterator<T> it = arrayList.iterator();
            int i16 = 0;
            while (it.hasNext()) {
                Integer num = ((MsgElement) it.next()).fileElement.transferStatus;
                if (num != null && num.intValue() == 4) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16 && (i16 = i16 + 1) < 0) {
                    CollectionsKt__CollectionsKt.throwCountOverflow();
                }
            }
            i3 = i16;
        }
        Integer num2 = q1().getMsgRecord().fileGroupSize;
        Intrinsics.checkNotNullExpressionValue(num2, "mCurrentMsgItem.msgRecord.fileGroupSize");
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(i3, num2.intValue());
        return coerceAtMost;
    }

    private final RelativeLayout O1() {
        return (RelativeLayout) this.container.getValue();
    }

    private final View P1() {
        return (View) this.contentView.getValue();
    }

    private final com.tencent.android.androidbypass.parser.a Q1() {
        return (com.tencent.android.androidbypass.parser.a) this.mMarkdownParser.getValue();
    }

    private final TextView R1() {
        return (TextView) this.picCountView.getValue();
    }

    private final TextView S1() {
        return (TextView) this.picView.getValue();
    }

    private final String T1(FileElement fileElement) {
        HashMap<Integer, String> hashMap = fileElement.picThumbPath;
        if (hashMap == null || hashMap.isEmpty()) {
            return "";
        }
        Pair pair = new Pair(0, "");
        for (Map.Entry<Integer, String> entry : fileElement.picThumbPath.entrySet()) {
            Integer key = entry.getKey();
            Intrinsics.checkNotNullExpressionValue(key, "entry.key");
            if (key.intValue() > ((Number) pair.getFirst()).intValue()) {
                pair = new Pair(entry.getKey(), entry.getValue());
            }
        }
        return (String) pair.getSecond();
    }

    private final int U1() {
        return ((Number) this.thumbSize.getValue()).intValue();
    }

    private final void V1(List<Object> payloads) {
        for (Object obj : payloads) {
            if (obj instanceof HashMap) {
                Map map = (Map) obj;
                if (map.get(AIOMsgItemPayloadType.FILE_TRANSFER_END_PAYLOAD) != null) {
                    c2();
                    Z1();
                }
                if (map.get(AIOMsgItemPayloadType.RICH_MEDIA_PAYLOAD) != null) {
                    c2();
                    Z1();
                }
                if (map.get(AIOMsgItemPayloadType.FILE_THUMB_TRANSFER_END_PAYLOAD) != null) {
                    a2();
                }
            }
        }
    }

    private final void W1() {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AIOMultiPicContentComponent$handleThumb$1(this, null), 3, null);
    }

    private final void X1() {
        if (Y1()) {
            ProgressBar progressBar = this.progressBar;
            if (progressBar != null) {
                progressBar.setVisibility(8);
                return;
            }
            return;
        }
        if (this.progressBar == null) {
            ProgressBar progressBar2 = new ProgressBar(this.context, null, android.R.attr.progressBarStyleHorizontal);
            progressBar2.setId(R.id.shm);
            com.tencent.aio.view_dsl.dsl.d.b(progressBar2, R.drawable.j7t);
            com.tencent.aio.view_dsl.dsl.f.p(progressBar2, com.tencent.aio.view_dsl.dsl.b.d());
            this.progressBar = progressBar2;
            progressBar2.setBackgroundColor(this.context.getColor(R.color.qui_common_bg_aio_01));
            RelativeLayout O1 = O1();
            ProgressBar progressBar3 = this.progressBar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, p.b(2.0f));
            layoutParams.addRule(7, R.id.sjj);
            layoutParams.addRule(5, R.id.sjj);
            layoutParams.addRule(3, R.id.sjj);
            layoutParams.leftMargin = p.b(6.0f);
            layoutParams.rightMargin = p.b(6.0f);
            layoutParams.topMargin = p.b(2.0f);
            Unit unit = Unit.INSTANCE;
            O1.addView(progressBar3, layoutParams);
            ProgressBar progressBar4 = this.progressBar;
            if (progressBar4 != null) {
                progressBar4.setMax(100);
            }
        }
    }

    private final boolean Y1() {
        boolean z16;
        ArrayList<MsgElement> arrayList = q1().getMsgRecord().elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "mCurrentMsgItem.msgRecord.elements");
        if ((arrayList instanceof Collection) && arrayList.isEmpty()) {
            return true;
        }
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            Integer num = ((MsgElement) it.next()).fileElement.transferStatus;
            if (num != null && num.intValue() == 4) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                return false;
            }
        }
        return true;
    }

    private final void Z1() {
        int N1 = (int) ((N1() / q1().getMsgRecord().fileGroupSize.intValue()) * 100);
        ProgressBar progressBar = this.progressBar;
        if (progressBar != null) {
            if (N1 < 100) {
                progressBar.setProgress(N1);
            } else {
                progressBar.setVisibility(8);
            }
        }
    }

    private final void a2() {
        String joinToString$default;
        boolean z16;
        Object obj;
        String str;
        String replace$default;
        String replace$default2;
        boolean z17;
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < 3; i3++) {
            ArrayList<MsgElement> arrayList2 = q1().getMsgRecord().elements;
            Intrinsics.checkNotNullExpressionValue(arrayList2, "mCurrentMsgItem.msgRecord.elements");
            Iterator<T> it = arrayList2.iterator();
            while (true) {
                z16 = true;
                if (it.hasNext()) {
                    obj = it.next();
                    Integer num = ((MsgElement) obj).fileElement.fileGroupIndex;
                    if (num != null && num.intValue() == i3) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            MsgElement msgElement = (MsgElement) obj;
            if (msgElement != null) {
                FileElement fileElement = msgElement.fileElement;
                Intrinsics.checkNotNullExpressionValue(fileElement, "it.fileElement");
                replace$default = StringsKt__StringsJVMKt.replace$default(T1(fileElement), "(", "\\(", false, 4, (Object) null);
                replace$default2 = StringsKt__StringsJVMKt.replace$default(replace$default, ")", "\\)", false, 4, (Object) null);
                int U1 = U1();
                int U12 = U1();
                if (replace$default2.length() != 0) {
                    z16 = false;
                }
                if (z16) {
                    replace$default2 = "unknown";
                }
                str = "![img#" + U1 + "px #" + U12 + "px](" + ((Object) replace$default2) + ")";
                if (str != null) {
                    arrayList.add(str);
                }
            }
            str = "![img#" + U1() + "px #" + U1() + "px](unknown)";
            arrayList.add(str);
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, " ", null, null, 0, null, null, 62, null);
        a.C0724a.a(Q1(), joinToString$default, S1(), null, 4, null);
    }

    private final void c2() {
        int N1 = N1();
        R1().setText(N1 + "/" + q1().getMsgRecord().fileGroupSize);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent
    @NotNull
    /* renamed from: M1, reason: merged with bridge method [inline-methods] */
    public b createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new b();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.mobileqq.aio.msglist.holder.component.c
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(position), msgItem, payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.b1(position, msgItem, payloads);
        W1();
        if (x1()) {
            return;
        }
        if (!payloads.isEmpty()) {
            V1(payloads);
            return;
        }
        S1().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.multipci.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AIOMultiPicContentComponent.K1(AIOMultiPicContentComponent.this, view);
            }
        });
        X1();
        c2();
        Z1();
        a2();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    @NotNull
    public View c1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return P1();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent
    @NotNull
    public List<com.tencent.qqnt.aio.menu.ui.d> s1() {
        List<com.tencent.qqnt.aio.menu.ui.d> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(new h(getMContext(), q1(), this));
            return listOf;
        }
        return (List) iPatchRedirector.redirect((short) 5, (Object) this);
    }
}
