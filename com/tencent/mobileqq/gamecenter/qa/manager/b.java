package com.tencent.mobileqq.gamecenter.qa.manager;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.gamecenter.qa.manager.b;
import com.tencent.mobileqq.gamecenter.qa.model.GameQALinkCardData;
import com.tencent.mobileqq.gamecenter.qa.util.GameQAUtil;
import com.tencent.mobileqq.gamecenter.qa.view.ab;
import com.tencent.mobileqq.gamecenter.qa.view.s;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import com.tencent.xweb.FileReaderHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 22\u00020\u0001:\u0002)-B\u0007\u00a2\u0006\u0004\b0\u00101J\b\u0010\u0003\u001a\u00020\u0002H\u0002JX\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002JX\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002J\u0010\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001b\u001a\u00020\u0002H\u0002J8\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J8\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J8\u0010 \u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J0\u0010!\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012JV\u0010\"\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\u0006\u0010#\u001a\u00020\u0002J@\u0010'\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010$\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000f0%2\u0006\u0010\u0011\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/manager/b;", "", "", "i", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "actionType", "", "enableLinkCard", "", MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK, "title", "Landroid/widget/EditText;", FileReaderHelper.ET_EXT, "Lcom/tencent/mobileqq/gamecenter/qa/view/ab;", TtmlNode.TAG_SPAN, "isNightTheme", "Lcom/tencent/mobileqq/gamecenter/qa/view/s$b;", "ls", "j", "Lcom/tencent/mobileqq/gamecenter/qa/model/GameQALinkCardData;", "cardData", tl.h.F, "Landroid/view/View;", "view", "p", ReportConstant.COSTREPORT_PREFIX, "linkSpan", "g", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "url", DomainData.DOMAIN_NAME, "l", "r", "o", "editText", "", "linkSpanList", "t", "Lfe1/c;", "a", "Lfe1/c;", "mGameStrategyHandler", "Lcom/tencent/mobileqq/gamecenter/qa/view/s;", "b", "Lcom/tencent/mobileqq/gamecenter/qa/view/s;", "mCurEditLinkDialog", "<init>", "()V", "c", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private fe1.c mGameStrategyHandler;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private s mCurEditLinkDialog;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001c\u0010\u0005\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0007R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\bR\u0014\u0010\f\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\bR\u0014\u0010\r\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/manager/b$a;", "", "", "title", MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK, "a", "", "SHOW_KEYBOARD_DELAY", "I", "TAG", "Ljava/lang/String;", "TYPE_INSERT_NEW_LINK", "TYPE_MODIFY_LINK", "TYPE_MODIFY_LINK_CARD", "<init>", "()V", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.gamecenter.qa.manager.b$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final String a(@Nullable String title, @Nullable String link) {
            if (!TextUtils.isEmpty(title)) {
                link = GameQAUtil.C(title);
            }
            return " " + link + " ";
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\t\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/gamecenter/qa/manager/b$c", "Lcom/tencent/mobileqq/gamecenter/qa/view/ab$b;", "", "actionType", "", MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK, "title", "", "a", "b", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class c implements ab.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f212543b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f212544c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ EditText f212545d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ab f212546e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f212547f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ s.b f212548g;

        c(Activity activity, boolean z16, EditText editText, ab abVar, boolean z17, s.b bVar) {
            this.f212543b = activity;
            this.f212544c = z16;
            this.f212545d = editText;
            this.f212546e = abVar;
            this.f212547f = z17;
            this.f212548g = bVar;
        }

        @Override // com.tencent.mobileqq.gamecenter.qa.view.ab.b
        public void a(int actionType, @Nullable String link, @Nullable String title) {
            b.this.r(this.f212543b, actionType, this.f212544c, link, title, this.f212545d, this.f212546e, this.f212547f, this.f212548g);
        }

        @Override // com.tencent.mobileqq.gamecenter.qa.view.ab.b
        public void b(@Nullable String link) {
            boolean b16 = GameQAUtil.b(link);
            if (b16) {
                b.this.s();
            }
            QLog.i("GameStrategyLinkHandler", 1, "[onCopy] success:" + b16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\t\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/gamecenter/qa/manager/b$d", "Lcom/tencent/mobileqq/gamecenter/qa/view/ab$b;", "", "actionType", "", MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK, "title", "", "a", "b", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class d implements ab.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f212550b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f212551c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ EditText f212552d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ab f212553e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f212554f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ s.b f212555g;

        d(Activity activity, boolean z16, EditText editText, ab abVar, boolean z17, s.b bVar) {
            this.f212550b = activity;
            this.f212551c = z16;
            this.f212552d = editText;
            this.f212553e = abVar;
            this.f212554f = z17;
            this.f212555g = bVar;
        }

        @Override // com.tencent.mobileqq.gamecenter.qa.view.ab.b
        public void a(int actionType, @Nullable String link, @Nullable String title) {
            b.this.r(this.f212550b, actionType, this.f212551c, link, title, this.f212552d, this.f212553e, this.f212554f, this.f212555g);
        }

        @Override // com.tencent.mobileqq.gamecenter.qa.view.ab.b
        public void b(@Nullable String link) {
            boolean b16 = GameQAUtil.b(link);
            if (b16) {
                b.this.s();
            }
            QLog.i("GameStrategyLinkHandler", 1, "[onCopy] success:" + b16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\n\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u000b\u001a\u00020\u0007H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/gamecenter/qa/manager/b$e", "Lcom/tencent/mobileqq/gamecenter/qa/view/s$b;", "", "newLink", "newTitle", "Lcom/tencent/mobileqq/gamecenter/qa/view/ab;", TtmlNode.TAG_SPAN, "", "a", MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK, "b", "onCancel", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class e implements s.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ s f212556a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f212557b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ EditText f212558c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f212559d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f212560e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Activity f212561f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f212562g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f212563h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ boolean f212564i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ s.b f212565j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<GameQALinkCardData> f212566k;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/gamecenter/qa/manager/b$e$a", "Lfe1/a;", "", "errorCode", "Lcom/tencent/mobileqq/gamecenter/qa/model/GameQALinkCardData;", "data", "sequenceId", "", "onGetRefMaterialByLink", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes12.dex */
        public static final class a extends fe1.a {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Ref.ObjectRef<GameQALinkCardData> f212567d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ b f212568e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ s f212569f;

            a(Ref.ObjectRef<GameQALinkCardData> objectRef, b bVar, s sVar) {
                this.f212567d = objectRef;
                this.f212568e = bVar;
                this.f212569f = sVar;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void b(s dialog, GameQALinkCardData gameQALinkCardData) {
                Intrinsics.checkNotNullParameter(dialog, "$dialog");
                dialog.setTitle(gameQALinkCardData.getTitle());
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // fe1.a, fe1.d
            public void onGetRefMaterialByLink(long errorCode, @Nullable final GameQALinkCardData data, long sequenceId) {
                QLog.d("GameStrategyLinkHandler", 1, "onGetRefMaterialByLink=", Long.valueOf(errorCode), Long.valueOf(errorCode));
                if (errorCode == 0 && data != 0) {
                    QLog.d("GameStrategyLinkHandler", 1, "onGetRefMaterialByLink, type=", data.getLinkType());
                    if (GameQAUtil.t(data)) {
                        this.f212567d.element = data;
                        MqqHandler uIHandler = ThreadManager.getUIHandler();
                        final s sVar = this.f212569f;
                        uIHandler.post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.manager.c
                            @Override // java.lang.Runnable
                            public final void run() {
                                b.e.a.b(s.this, data);
                            }
                        });
                    } else {
                        QLog.d("GameStrategyLinkHandler", 1, "onGetRefMaterialByLink, type not support=", data.getLinkType());
                    }
                }
                fe1.c cVar = this.f212568e.mGameStrategyHandler;
                if (cVar != null) {
                    cVar.N0();
                }
            }
        }

        e(s sVar, b bVar, EditText editText, String str, String str2, Activity activity, int i3, boolean z16, boolean z17, s.b bVar2, Ref.ObjectRef<GameQALinkCardData> objectRef) {
            this.f212556a = sVar;
            this.f212557b = bVar;
            this.f212558c = editText;
            this.f212559d = str;
            this.f212560e = str2;
            this.f212561f = activity;
            this.f212562g = i3;
            this.f212563h = z16;
            this.f212564i = z17;
            this.f212565j = bVar2;
            this.f212566k = objectRef;
        }

        @Override // com.tencent.mobileqq.gamecenter.qa.view.s.b
        public void a(@Nullable String newLink, @Nullable String newTitle, @Nullable ab span) {
            boolean equals$default;
            boolean equals$default2;
            this.f212556a.dismiss();
            this.f212557b.p(this.f212558c);
            equals$default = StringsKt__StringsJVMKt.equals$default(newLink, this.f212559d, false, 2, null);
            if (equals$default) {
                equals$default2 = StringsKt__StringsJVMKt.equals$default(newTitle, this.f212560e, false, 2, null);
                if (equals$default2) {
                    return;
                }
            }
            if (span != null) {
                span.m();
            }
            this.f212557b.h(this.f212561f, this.f212562g, this.f212563h, newLink, newTitle, this.f212558c, this.f212564i, this.f212565j, this.f212566k.element);
            s.b bVar = this.f212565j;
            if (bVar != null) {
                bVar.a(newLink, newTitle, span);
            }
        }

        @Override // com.tencent.mobileqq.gamecenter.qa.view.s.b
        public void b(@Nullable String link) {
            if (this.f212563h && !TextUtils.isEmpty(link) && GameQAUtil.q(link)) {
                fe1.c cVar = this.f212557b.mGameStrategyHandler;
                if (cVar != null) {
                    cVar.N0();
                }
                this.f212557b.mGameStrategyHandler = new fe1.c();
                fe1.c cVar2 = this.f212557b.mGameStrategyHandler;
                if (cVar2 != null) {
                    cVar2.Z0(new a(this.f212566k, this.f212557b, this.f212556a));
                }
                this.f212566k.element = null;
                fe1.c cVar3 = this.f212557b.mGameStrategyHandler;
                if (cVar3 != null) {
                    cVar3.a0(link, 0L);
                }
            }
        }

        @Override // com.tencent.mobileqq.gamecenter.qa.view.s.b
        public void onCancel() {
            this.f212556a.dismiss();
            this.f212557b.p(this.f212558c);
            s.b bVar = this.f212565j;
            if (bVar != null) {
                bVar.onCancel();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\t\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/gamecenter/qa/manager/b$f", "Lcom/tencent/mobileqq/gamecenter/qa/view/ab$b;", "", "actionType", "", MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK, "title", "", "a", "b", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class f implements ab.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f212571b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f212572c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ EditText f212573d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ab f212574e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f212575f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ s.b f212576g;

        f(Activity activity, boolean z16, EditText editText, ab abVar, boolean z17, s.b bVar) {
            this.f212571b = activity;
            this.f212572c = z16;
            this.f212573d = editText;
            this.f212574e = abVar;
            this.f212575f = z17;
            this.f212576g = bVar;
        }

        @Override // com.tencent.mobileqq.gamecenter.qa.view.ab.b
        public void a(int actionType, @Nullable String link, @Nullable String title) {
            b.this.r(this.f212571b, actionType, this.f212572c, link, title, this.f212573d, this.f212574e, this.f212575f, this.f212576g);
        }

        @Override // com.tencent.mobileqq.gamecenter.qa.view.ab.b
        public void b(@Nullable String link) {
            boolean b16 = GameQAUtil.b(link);
            if (b16) {
                b.this.s();
            }
            QLog.i("GameStrategyLinkHandler", 1, "[onCopy] success:" + b16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\t\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/gamecenter/qa/manager/b$g", "Lcom/tencent/mobileqq/gamecenter/qa/view/ab$b;", "", "actionType", "", MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK, "title", "", "a", "b", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class g implements ab.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f212578b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f212579c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ EditText f212580d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ab f212581e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f212582f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ s.b f212583g;

        g(Activity activity, boolean z16, EditText editText, ab abVar, boolean z17, s.b bVar) {
            this.f212578b = activity;
            this.f212579c = z16;
            this.f212580d = editText;
            this.f212581e = abVar;
            this.f212582f = z17;
            this.f212583g = bVar;
        }

        @Override // com.tencent.mobileqq.gamecenter.qa.view.ab.b
        public void a(int actionType, @Nullable String link, @Nullable String title) {
            b.this.r(this.f212578b, actionType, this.f212579c, link, title, this.f212580d, this.f212581e, this.f212582f, this.f212583g);
        }

        @Override // com.tencent.mobileqq.gamecenter.qa.view.ab.b
        public void b(@Nullable String link) {
            boolean b16 = GameQAUtil.b(link);
            if (b16) {
                b.this.s();
            }
            QLog.i("GameStrategyLinkHandler", 1, "[onCopy] success:" + b16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\t\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/gamecenter/qa/manager/b$h", "Lcom/tencent/mobileqq/gamecenter/qa/view/ab$b;", "", "actionType", "", MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK, "title", "", "a", "b", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class h implements ab.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f212585b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f212586c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ EditText f212587d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ab f212588e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f212589f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ s.b f212590g;

        h(Activity activity, boolean z16, EditText editText, ab abVar, boolean z17, s.b bVar) {
            this.f212585b = activity;
            this.f212586c = z16;
            this.f212587d = editText;
            this.f212588e = abVar;
            this.f212589f = z17;
            this.f212590g = bVar;
        }

        @Override // com.tencent.mobileqq.gamecenter.qa.view.ab.b
        public void a(int actionType, @Nullable String link, @Nullable String title) {
            b.this.r(this.f212585b, actionType, this.f212586c, link, title, this.f212587d, this.f212588e, this.f212589f, this.f212590g);
        }

        @Override // com.tencent.mobileqq.gamecenter.qa.view.ab.b
        public void b(@Nullable String link) {
            boolean b16 = GameQAUtil.b(link);
            if (b16) {
                b.this.s();
            }
            QLog.i("GameStrategyLinkHandler", 1, "[onCopy] success:" + b16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(Activity activity, int actionType, boolean enableLinkCard, String link, String title, EditText et5, boolean isNightTheme, s.b ls5, GameQALinkCardData cardData) {
        ab a16 = ab.INSTANCE.a(link, title, enableLinkCard);
        a16.i(et5);
        a16.D(new d(activity, enableLinkCard, et5, a16, isNightTheme, ls5));
        if (enableLinkCard && GameQAUtil.q(link)) {
            if (actionType != 0) {
                if (actionType == 2) {
                    a16.B(activity, null, title);
                    return;
                }
                return;
            }
            a16.B(activity, cardData, title);
        }
    }

    private final void i() {
        s sVar = this.mCurEditLinkDialog;
        if (sVar != null) {
            Intrinsics.checkNotNull(sVar);
            if (sVar.isShowing()) {
                s sVar2 = this.mCurEditLinkDialog;
                Intrinsics.checkNotNull(sVar2);
                sVar2.dismiss();
            }
        }
    }

    private final void j(Activity activity, int actionType, boolean enableLinkCard, String link, String title, EditText et5, ab span, boolean isNightTheme, s.b ls5) {
        String string;
        s sVar = new s(activity, R.style.qZoneInputDialog);
        sVar.b0(isNightTheme);
        sVar.setContentView(R.layout.f167993ec3);
        sVar.setCanceledOnTouchOutside(false);
        if (actionType == 0) {
            string = activity.getResources().getString(R.string.f1370805w);
            Intrinsics.checkNotNullExpressionValue(string, "activity.resources.getSt\u2026strategy_insert_new_link)");
        } else {
            string = activity.getResources().getString(R.string.f13712060);
            Intrinsics.checkNotNullExpressionValue(string, "activity.resources.getSt\u2026ter_strategy_modify_link)");
        }
        sVar.d0(string);
        sVar.e0(link, title, span);
        sVar.c0(new e(sVar, this, et5, link, title, activity, actionType, enableLinkCard, isNightTheme, ls5, new Ref.ObjectRef()));
        this.mCurEditLinkDialog = sVar;
    }

    @JvmStatic
    @NotNull
    public static final String k(@Nullable String str, @Nullable String str2) {
        return INSTANCE.a(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(final View view) {
        view.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.manager.a
            @Override // java.lang.Runnable
            public final void run() {
                b.q(view);
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(View view) {
        Intrinsics.checkNotNullParameter(view, "$view");
        InputMethodUtil.show(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s() {
        QQToast.makeText(BaseApplication.context, R.string.f1370605u, 0).show();
    }

    @NotNull
    public final ab g(@NotNull Activity activity, @NotNull EditText et5, @NotNull ab linkSpan, boolean enableLinkCard, boolean isNightTheme, @Nullable s.b ls5) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(et5, "et");
        Intrinsics.checkNotNullParameter(linkSpan, "linkSpan");
        ab j3 = linkSpan.j();
        j3.D(new c(activity, enableLinkCard, et5, j3, isNightTheme, ls5));
        return j3;
    }

    public final void l(@NotNull Activity activity, @NotNull EditText et5, boolean enableLinkCard, boolean isNightTheme, @Nullable s.b ls5) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(et5, "et");
        r(activity, 0, enableLinkCard, "", "", et5, null, isNightTheme, ls5);
    }

    public final void m(@NotNull Activity activity, @NotNull EditText et5, @NotNull GameQALinkCardData cardData, boolean enableLinkCard, boolean isNightTheme, @Nullable s.b ls5) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(et5, "et");
        Intrinsics.checkNotNullParameter(cardData, "cardData");
        ab a16 = ab.INSTANCE.a(cardData.getUrl(), cardData.getTitle(), enableLinkCard);
        a16.i(et5);
        a16.D(new f(activity, enableLinkCard, et5, a16, isNightTheme, ls5));
        if (enableLinkCard && GameQAUtil.q(cardData.getUrl())) {
            a16.B(activity, cardData, null);
        }
    }

    public final void n(@NotNull Activity activity, @NotNull EditText et5, @NotNull String url, boolean enableLinkCard, boolean isNightTheme, @Nullable s.b ls5) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(et5, "et");
        Intrinsics.checkNotNullParameter(url, "url");
        ab a16 = ab.INSTANCE.a(url, null, enableLinkCard);
        a16.i(et5);
        a16.D(new g(activity, enableLinkCard, et5, a16, isNightTheme, ls5));
        if (enableLinkCard && GameQAUtil.q(url)) {
            a16.B(activity, null, null);
        }
    }

    public final void o() {
        i();
    }

    public final void r(@NotNull Activity activity, int actionType, boolean enableLinkCard, @Nullable String link, @Nullable String title, @NotNull EditText et5, @Nullable ab span, boolean isNightTheme, @Nullable s.b ls5) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(et5, "et");
        i();
        j(activity, actionType, enableLinkCard, link, title, et5, span, isNightTheme, ls5);
    }

    public final void t(@Nullable Activity activity, @NotNull EditText editText, boolean enableLinkCard, @NotNull List<ab> linkSpanList, boolean isNightTheme, @Nullable s.b ls5) {
        Intrinsics.checkNotNullParameter(editText, "editText");
        Intrinsics.checkNotNullParameter(linkSpanList, "linkSpanList");
        if (activity == null) {
            return;
        }
        for (ab abVar : linkSpanList) {
            abVar.I(editText);
            abVar.D(new h(activity, enableLinkCard, editText, abVar, isNightTheme, ls5));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/manager/b$b;", "Lcom/tencent/mobileqq/gamecenter/qa/view/s$b;", "", "onCancel", "", MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK, "b", "<init>", "()V", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.gamecenter.qa.manager.b$b, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public static abstract class AbstractC7648b implements s.b {
        @Override // com.tencent.mobileqq.gamecenter.qa.view.s.b
        public void onCancel() {
        }

        @Override // com.tencent.mobileqq.gamecenter.qa.view.s.b
        public void b(@Nullable String link) {
        }
    }
}
