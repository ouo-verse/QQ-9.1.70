package com.tencent.mobileqq.aio.msgbox;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.aio.msgbox.event.MsgBoxEvent;
import com.tencent.mobileqq.aio.utils.as;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.mobileqq.text.IEmoticonSpanRefreshCallback;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqnt.aio.adapter.api.IQQTextApi;
import com.tencent.qqnt.emoticon.api.IEmoticonApi;
import com.tencent.qqnt.emotion.text.style.api.IEmojiSpanService;
import com.tencent.qqnt.kernel.nativeinterface.FaceElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.MsgAbstractElement;
import com.tencent.qqnt.msg.e;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import w71.f;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 =2\u00020\u0001:\u0001>B\u000f\u0012\u0006\u0010%\u001a\u00020 \u00a2\u0006\u0004\b;\u0010<J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010\u0012\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u0015\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u0016\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J \u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0018\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001aH\u0016R\u0017\u0010%\u001a\u00020 8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R+\u0010-\u001a\u0012\u0012\u0004\u0012\u00020'0&j\b\u0012\u0004\u0012\u00020'`(8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R+\u00101\u001a\u0012\u0012\u0004\u0012\u00020.0&j\b\u0012\u0004\u0012\u00020.`(8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b/\u0010*\u001a\u0004\b0\u0010,R\u0014\u00104\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u00103R\u001b\u00108\u001a\u0002058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b6\u0010*\u001a\u0004\b6\u00107R\u0014\u0010:\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00109\u00a8\u0006?"}, d2 = {"Lcom/tencent/mobileqq/aio/msgbox/MsgBox;", "Landroid/graphics/drawable/Drawable$Callback;", "Landroid/content/Context;", "k", "", "content", "", "u", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "info", "", "t", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "j", "", "name", "r", "Landroid/view/View;", "o", "v", "g", "Landroid/graphics/drawable/Drawable;", "who", "invalidateDrawable", "Ljava/lang/Runnable;", "what", "", RemoteMessageConst.Notification.WHEN, "scheduleDrawable", "unscheduleDrawable", "Lcom/tencent/aio/api/runtime/a;", "d", "Lcom/tencent/aio/api/runtime/a;", h.F, "()Lcom/tencent/aio/api/runtime/a;", "aioContext", "Ljava/util/ArrayList;", "Ljv3/a;", "Lkotlin/collections/ArrayList;", "e", "Lkotlin/Lazy;", "l", "()Ljava/util/ArrayList;", "msgBoxFilters", "Ljv3/b;", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "msgBoxListeners", "Lcom/tencent/qqnt/msg/e;", "Lcom/tencent/qqnt/msg/e;", "summaryDecoder", "Lw71/f;", "i", "()Lw71/f;", "binding", "Ljava/lang/Runnable;", "hideMsgBoxAction", "<init>", "(Lcom/tencent/aio/api/runtime/a;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class MsgBox implements Drawable.Callback {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/AIO/tips/aio_tips_inject_config.yml", version = 3)
    @NotNull
    private static final ArrayList<Class<jv3.a>> D;

    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/AIO/tips/aio_tips_inject_config.yml", version = 3)
    @NotNull
    private static final ArrayList<Class<jv3.b>> E;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.aio.api.runtime.a aioContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy msgBoxFilters;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy msgBoxListeners;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e summaryDecoder;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy binding;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable hideMsgBoxAction;

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u000bR<\u0010\u0006\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003`\u00058\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR<\u0010\r\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00030\u0002j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0003`\u00058\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0007\u0012\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u000e\u0010\tR\u0014\u0010\u0011\u001a\u00020\u00108\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00108\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00148\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/aio/msgbox/MsgBox$a;", "", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Ljv3/a;", "Lkotlin/collections/ArrayList;", "msgBoxFilterClasses", "Ljava/util/ArrayList;", "a", "()Ljava/util/ArrayList;", "getMsgBoxFilterClasses$annotations", "()V", "Ljv3/b;", "msgBoxListenerClasses", "b", "getMsgBoxListenerClasses$annotations", "", "MAX_LENGTH_OF_NAME", "I", "MOS_BOX_EMO_SIZE", "", "TAG", "Ljava/lang/String;", "<init>", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msgbox.MsgBox$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final ArrayList<Class<jv3.a>> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return MsgBox.D;
            }
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this);
        }

        @NotNull
        public final ArrayList<Class<jv3.b>> b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return MsgBox.E;
            }
            return (ArrayList) iPatchRedirector.redirect((short) 3, (Object) this);
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/msgbox/MsgBox$b", "Lcom/tencent/qqnt/msg/e;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", DTConstants.TAG.ELEMENT, "", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b implements e {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qqnt.msg.e
        @Nullable
        public CharSequence a(@NotNull MsgElement element) {
            int intValue;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (CharSequence) iPatchRedirector.redirect((short) 2, (Object) this, (Object) element);
            }
            Intrinsics.checkNotNullParameter(element, "element");
            if (element.elementType == 6) {
                FaceElement faceElement = element.faceElement;
                Integer num = faceElement.imageType;
                if (num == null) {
                    intValue = 0;
                } else {
                    intValue = num.intValue();
                }
                int i3 = intValue;
                QRouteApi api = QRoute.api(IEmojiSpanService.class);
                Intrinsics.checkNotNullExpressionValue(api, "api(IEmojiSpanService::class.java)");
                return IQQTextApi.a.c((IQQTextApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IQQTextApi.class), IEmojiSpanService.a.a((IEmojiSpanService) api, faceElement.faceType, faceElement.faceIndex, i3, false, 0, 24, null), 5, 18, null, null, 24, null);
            }
            return null;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57739);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        INSTANCE = new Companion(null);
        ArrayList<Class<jv3.a>> arrayList = new ArrayList<>();
        D = arrayList;
        arrayList.add(com.tencent.mobileqq.app.nthiddenchat.a.class);
        E = new ArrayList<>();
    }

    public MsgBox(@NotNull com.tencent.aio.api.runtime.a aioContext) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aioContext);
            return;
        }
        this.aioContext = aioContext;
        lazy = LazyKt__LazyJVMKt.lazy(MsgBox$msgBoxFilters$2.INSTANCE);
        this.msgBoxFilters = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(MsgBox$msgBoxListeners$2.INSTANCE);
        this.msgBoxListeners = lazy2;
        this.summaryDecoder = new b();
        lazy3 = LazyKt__LazyJVMKt.lazy(new MsgBox$binding$2(this));
        this.binding = lazy3;
        this.hideMsgBoxAction = new Runnable() { // from class: com.tencent.mobileqq.aio.msgbox.b
            @Override // java.lang.Runnable
            public final void run() {
                MsgBox.s(MsgBox.this);
            }
        };
    }

    private final f i() {
        return (f) this.binding.getValue();
    }

    private final CharSequence j(RecentContactInfo info) {
        ArrayList<MsgAbstractElement> arrayList;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (info != null && (arrayList = info.abstractContent) != null) {
            for (MsgAbstractElement msgAbstractElement : arrayList) {
                int i3 = msgAbstractElement.elementType;
                if (i3 == 6 && msgAbstractElement.index != null) {
                    Integer num = msgAbstractElement.elementSubType;
                    if (num != null && num.intValue() == 5) {
                        spannableStringBuilder.append((CharSequence) msgAbstractElement.content);
                    } else {
                        QRouteApi api = QRoute.api(IEmojiSpanService.class);
                        Intrinsics.checkNotNullExpressionValue(api, "api(IEmojiSpanService::class.java)");
                        IEmojiSpanService iEmojiSpanService = (IEmojiSpanService) api;
                        Integer num2 = msgAbstractElement.elementSubType;
                        Intrinsics.checkNotNullExpressionValue(num2, "it.elementSubType");
                        int intValue = num2.intValue();
                        Integer num3 = msgAbstractElement.index;
                        Intrinsics.checkNotNullExpressionValue(num3, "it.index");
                        spannableStringBuilder.append(IEmojiSpanService.a.a(iEmojiSpanService, intValue, num3.intValue(), 0, false, 0, 28, null));
                    }
                } else if (i3 == 23) {
                    spannableStringBuilder.append((CharSequence) HardCodeUtil.qqStr(R.string.f168452fo));
                } else {
                    spannableStringBuilder.append((CharSequence) msgAbstractElement.content);
                }
            }
        }
        return spannableStringBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Context k() {
        Context context = this.aioContext.c().getContext();
        if (context == null) {
            BaseApplication context2 = BaseApplication.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext()");
            return context2;
        }
        return context;
    }

    private final ArrayList<jv3.a> l() {
        return (ArrayList) this.msgBoxFilters.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArrayList<jv3.b> m() {
        return (ArrayList) this.msgBoxListeners.getValue();
    }

    private final CharSequence n(RecentContactInfo info) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        CharSequence q16 = q(info);
        SpannableStringBuilder append = spannableStringBuilder.append(q16).append((CharSequence) MsgSummary.STR_COLON).append(p(info));
        Intrinsics.checkNotNullExpressionValue(append, "result.append(prefix).append(\": \").append(content)");
        return append;
    }

    private final CharSequence p(RecentContactInfo info) {
        Iterator<jv3.a> it = l().iterator();
        CharSequence charSequence = null;
        while (it.hasNext() && (charSequence = it.next().a(this.aioContext, info)) == null) {
        }
        if (charSequence == null) {
            return j(info);
        }
        return charSequence;
    }

    private final CharSequence q(RecentContactInfo info) {
        boolean z16;
        CharSequence charSequence;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Iterator<jv3.a> it = l().iterator();
        while (it.hasNext()) {
            CharSequence b16 = it.next().b(this.aioContext, info);
            if (b16 != null) {
                spannableStringBuilder.append(b16);
            }
        }
        boolean z17 = true;
        if (spannableStringBuilder.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (info == null || info.chatType != 2) {
                z17 = false;
            }
            CharSequence charSequence2 = null;
            if (z17) {
                if (info != null) {
                    charSequence = as.a(info);
                } else {
                    charSequence = null;
                }
                spannableStringBuilder.append((CharSequence) ("[" + r(as.b(charSequence)) + "]")).append((CharSequence) " ");
            }
            if (info != null) {
                charSequence2 = as.c(info);
            }
            spannableStringBuilder.append((CharSequence) r(as.b(charSequence2)));
        }
        return spannableStringBuilder;
    }

    private final String r(String name) {
        if (TextUtils.isEmpty(name)) {
            return "";
        }
        Intrinsics.checkNotNull(name);
        if (name.length() > 10) {
            String substring = name.substring(0, 10);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            return substring + MiniBoxNoticeInfo.APPNAME_SUFFIX;
        }
        return name;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(MsgBox this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.aioContext.e().h(new MsgBoxEvent.HideMsgBoxEvent());
    }

    private final boolean t(RecentContactInfo info) {
        String str;
        String currentUin = MobileQQ.sMobileQQ.waitAppRuntime().getCurrentUin();
        String str2 = null;
        if (info != null) {
            str = info.senderUid;
        } else {
            str = null;
        }
        if (!TextUtils.equals(currentUin, str)) {
            String currentUid = MobileQQ.sMobileQQ.waitAppRuntime().getCurrentUid();
            if (info != null) {
                str2 = info.senderUid;
            }
            if (!TextUtils.equals(currentUid, str2)) {
                return false;
            }
        }
        return true;
    }

    private final void u(CharSequence content) {
        if (content instanceof Spanned) {
            Spanned spanned = (Spanned) content;
            IEmoticonSpanRefreshCallback[] iEmoticonSpanRefreshCallbackArr = (IEmoticonSpanRefreshCallback[]) spanned.getSpans(0, spanned.length(), ((IEmoticonApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IEmoticonApi.class)).getEmoticonSpanClass());
            Drawable[] drawableArr = new Drawable[iEmoticonSpanRefreshCallbackArr.length];
            int length = iEmoticonSpanRefreshCallbackArr.length;
            for (int i3 = 0; i3 < length; i3++) {
                IEmoticonSpanRefreshCallback iEmoticonSpanRefreshCallback = iEmoticonSpanRefreshCallbackArr[i3];
                Intrinsics.checkNotNullExpressionValue(iEmoticonSpanRefreshCallback, "images[i]");
                Drawable drawable = iEmoticonSpanRefreshCallback.getDrawable();
                drawableArr[i3] = drawable;
                if (drawable != null) {
                    Intrinsics.checkNotNull(drawable);
                    drawable.setCallback(this);
                }
            }
        }
    }

    public final void g(@Nullable RecentContactInfo info) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) info);
            return;
        }
        FrameLayout root = i().getRoot();
        root.removeCallbacks(this.hideMsgBoxAction);
        root.postDelayed(this.hideMsgBoxAction, 10000L);
        Iterator<jv3.b> it = m().iterator();
        while (it.hasNext()) {
            it.next().a(this.aioContext, info);
        }
    }

    @NotNull
    public final com.tencent.aio.api.runtime.a h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.aio.api.runtime.a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.aioContext;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NotNull Drawable who) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) who);
        } else {
            Intrinsics.checkNotNullParameter(who, "who");
            i().f444790b.invalidate();
        }
    }

    @NotNull
    public final View o(@Nullable RecentContactInfo info) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this, (Object) info);
        }
        CharSequence c16 = IQQTextApi.a.c((IQQTextApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IQQTextApi.class), n(info), 3, 16, null, null, 24, null);
        f i3 = i();
        i3.f444790b.setText(c16);
        i3.f444790b.setTag(info);
        CharSequence text = i3.f444790b.getText();
        Intrinsics.checkNotNullExpressionValue(text, "tvMsgBox.text");
        u(text);
        FrameLayout root = i().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NotNull Drawable who, @NotNull Runnable what, long when) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, who, what, Long.valueOf(when));
        } else {
            Intrinsics.checkNotNullParameter(who, "who");
            Intrinsics.checkNotNullParameter(what, "what");
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NotNull Drawable who, @NotNull Runnable what) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) who, (Object) what);
        } else {
            Intrinsics.checkNotNullParameter(who, "who");
            Intrinsics.checkNotNullParameter(what, "what");
        }
    }

    public final boolean v(@Nullable RecentContactInfo info) {
        String str;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) info)).booleanValue();
        }
        if (info != null) {
            str = info.peerUid;
        } else {
            str = null;
        }
        if (Intrinsics.areEqual(str, this.aioContext.g().r().c().j()) || t(info)) {
            return false;
        }
        if (info != null && info.chatType == 3) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return false;
        }
        Iterator<jv3.a> it = l().iterator();
        while (it.hasNext()) {
            if (!it.next().c(this.aioContext, info)) {
                return false;
            }
        }
        return true;
    }
}
