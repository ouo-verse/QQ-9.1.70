package com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AgreementConsentViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.module.CacheDiskLru;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBasePager;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.QuickCommentItem;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.StrangerFeedCommentRepoKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.CommentPanelState;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentInputOpenEvent;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes31.dex */
public final class NearbyFeedCommentInputPage extends NearbyBasePager {
    public static final /* synthetic */ int $r8$clinit = 0;
    public String cachedText;
    public NBPFeedCommentInputOpenEvent data;
    public aa<NBPFeedCommentInputView> inputViewRef;
    public final Lazy lruCache$delegate;
    public boolean submitted;

    public NearbyFeedCommentInputPage() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<CacheDiskLru>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NearbyFeedCommentInputPage$lruCache$2
            @Override // kotlin.jvm.functions.Function0
            public final CacheDiskLru invoke() {
                return new CacheDiskLru(2);
            }
        });
        this.lruCache$delegate = lazy;
        this.cachedText = "";
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        String str;
        final String str2;
        NBPFeedCommentInputOpenEvent nBPFeedCommentInputOpenEvent = this.data;
        if (nBPFeedCommentInputOpenEvent == null || (str = nBPFeedCommentInputOpenEvent.targetUserNickname) == null) {
            str = "";
        }
        if (nBPFeedCommentInputOpenEvent == null || (str2 = nBPFeedCommentInputOpenEvent.placeholder) == null) {
            if (str.length() > 0) {
                str2 = AgreementConsentViewKt$$ExternalSyntheticOutline0.m("\u56de\u590d ", str);
            } else {
                str2 = "\u671f\u5f85\u4f60\u7684\u7cbe\u5f69\u70b9\u8bc4";
            }
        }
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NearbyFeedCommentInputPage$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final NearbyFeedCommentInputPage nearbyFeedCommentInputPage = NearbyFeedCommentInputPage.this;
                final String str3 = str2;
                viewContainer.addChild(new NBPFeedCommentInputView(), new Function1<NBPFeedCommentInputView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NearbyFeedCommentInputPage$body$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(NBPFeedCommentInputView nBPFeedCommentInputView) {
                        NBPFeedCommentInputView nBPFeedCommentInputView2 = nBPFeedCommentInputView;
                        final NearbyFeedCommentInputPage nearbyFeedCommentInputPage2 = NearbyFeedCommentInputPage.this;
                        nBPFeedCommentInputView2.ref(nBPFeedCommentInputView2, new Function1<aa<NBPFeedCommentInputView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NearbyFeedCommentInputPage.body.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(aa<NBPFeedCommentInputView> aaVar) {
                                NearbyFeedCommentInputPage.this.inputViewRef = aaVar;
                                return Unit.INSTANCE;
                            }
                        });
                        final String str4 = str3;
                        final NearbyFeedCommentInputPage nearbyFeedCommentInputPage3 = NearbyFeedCommentInputPage.this;
                        nBPFeedCommentInputView2.attr(new Function1<NBPFeedCommentInputViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NearbyFeedCommentInputPage.body.1.1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPFeedCommentInputViewAttr nBPFeedCommentInputViewAttr) {
                                NBPFeedCommentInputViewAttr nBPFeedCommentInputViewAttr2 = nBPFeedCommentInputViewAttr;
                                nBPFeedCommentInputViewAttr2.placeHolder = str4;
                                NearbyFeedCommentInputPage nearbyFeedCommentInputPage4 = nearbyFeedCommentInputPage3;
                                nBPFeedCommentInputViewAttr2.cachedText = nearbyFeedCommentInputPage4.cachedText;
                                NBPFeedCommentInputOpenEvent nBPFeedCommentInputOpenEvent2 = nearbyFeedCommentInputPage4.data;
                                if (nBPFeedCommentInputOpenEvent2 != null) {
                                    nBPFeedCommentInputViewAttr2.quickComments = nBPFeedCommentInputOpenEvent2.quickComments;
                                    nBPFeedCommentInputViewAttr2.aiQuickComments = nBPFeedCommentInputOpenEvent2.aiQuickComments;
                                    nBPFeedCommentInputViewAttr2.panelState = nBPFeedCommentInputOpenEvent2.panelState;
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        final NearbyFeedCommentInputPage nearbyFeedCommentInputPage4 = NearbyFeedCommentInputPage.this;
                        nBPFeedCommentInputView2.event(new Function1<NBPFeedCommentInputViewEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NearbyFeedCommentInputPage.body.1.1.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPFeedCommentInputViewEvent nBPFeedCommentInputViewEvent) {
                                final NearbyFeedCommentInputPage nearbyFeedCommentInputPage5 = NearbyFeedCommentInputPage.this;
                                nBPFeedCommentInputViewEvent.onCloseCallback = new Function3<Boolean, String, Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NearbyFeedCommentInputPage.body.1.1.3.1
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(Boolean bool, String str5, Boolean bool2) {
                                        boolean booleanValue = bool2.booleanValue();
                                        NearbyFeedCommentInputPage nearbyFeedCommentInputPage6 = NearbyFeedCommentInputPage.this;
                                        int i3 = NearbyFeedCommentInputPage.$r8$clinit;
                                        nearbyFeedCommentInputPage6.closePage(bool.booleanValue(), str5, booleanValue);
                                        return Unit.INSTANCE;
                                    }
                                };
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        List<QuickCommentItem> list;
        String decodeToString;
        String decodeToString2;
        super.created();
        NBPFeedCommentInputOpenEvent fromJson = NBPFeedCommentInputOpenEvent.Companion.fromJson(getPagerData().n());
        Object[] sharePenetratePageData = QQNearbyModule.Companion.getInstance().getSharePenetratePageData();
        if (sharePenetratePageData != null) {
            try {
                Object obj = sharePenetratePageData[0];
                List<QuickCommentItem> list2 = null;
                byte[] bArr = obj instanceof byte[] ? (byte[]) obj : null;
                if (bArr != null) {
                    decodeToString2 = StringsKt__StringsJVMKt.decodeToString(bArr);
                    list = StrangerFeedCommentRepoKt.parseQuickCommentList(new b(decodeToString2));
                } else {
                    list = null;
                }
                if (list != null) {
                    fromJson.quickComments = list;
                    KLog.INSTANCE.i("NearbyFeedCommentInputPage", "parse quick comments: " + list.size());
                }
                Object obj2 = sharePenetratePageData[1];
                byte[] bArr2 = obj2 instanceof byte[] ? (byte[]) obj2 : null;
                if (bArr2 != null) {
                    decodeToString = StringsKt__StringsJVMKt.decodeToString(bArr2);
                    list2 = StrangerFeedCommentRepoKt.parseQuickCommentList(new b(decodeToString));
                }
                if (list2 != null) {
                    fromJson.aiQuickComments = list2;
                    KLog.INSTANCE.i("NearbyFeedCommentInputPage", "parse ai quick comments: " + list2.size());
                }
            } catch (Exception e16) {
                KLog kLog = KLog.INSTANCE;
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("parse quick comments error: ");
                m3.append(e16.getMessage());
                kLog.e("NearbyFeedCommentInputPage", m3.toString());
            }
        }
        QQNearbyModule.Companion.getInstance().setSharePenetratePageData(new byte[0]);
        KLog kLog2 = KLog.INSTANCE;
        StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("page opened: appId=");
        m16.append(fromJson.appId);
        m16.append(", feedId=");
        m16.append(fromJson.feedId);
        m16.append(", targetCommentId=");
        m16.append(fromJson.targetCommentId);
        m16.append(", targetReplyId=");
        m16.append(fromJson.targetReplyId);
        m16.append(", targetUserNickname=");
        m16.append(fromJson.targetUserNickname);
        m16.append(", placeholder=");
        m16.append(fromJson.placeholder);
        m16.append(", quickComments=");
        m16.append(fromJson.quickComments.size());
        kLog2.i("NearbyFeedCommentInputPage", m16.toString());
        k.b((k) acquireModule("KRNotifyModule"), "NBPCloseCommentInputPage", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_comment_input.NearbyFeedCommentInputPage$created$1$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar) {
                KLog.INSTANCE.e("NearbyFeedCommentInputPage", "Received NBPCloseCommentInputPage Notify");
                NearbyFeedCommentInputPage.this.closePage(false, "", false);
                return Unit.INSTANCE;
            }
        }, 2, null);
        String str = getLruCache().get(fromJson.feedId);
        if (str != null) {
            this.cachedText = str;
        }
        k.d((k) c.f117352a.g().acquireModule("KRNotifyModule"), "NBPFeedCommentInputOpenedEvent", fromJson.toJson(), false, 4, null);
        this.data = fromJson;
    }

    public final CacheDiskLru getLruCache() {
        return (CacheDiskLru) this.lruCache$delegate.getValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0030, code lost:
    
        if (r0 == true) goto L18;
     */
    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.pager.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onReceivePagerEvent(String str, e eVar) {
        boolean z16;
        NBPFeedCommentInputView b16;
        boolean z17;
        if (Intrinsics.areEqual(str, "onModalModeBackPressed")) {
            aa<NBPFeedCommentInputView> aaVar = this.inputViewRef;
            if (aaVar != null && (b16 = aaVar.b()) != null) {
                z16 = true;
                if (b16.getCurrentPanelState() == CommentPanelState.QQ_Emoji || b16.getCurrentPanelState() == CommentPanelState.AI_Quick_Comments) {
                    b16.switchPanelState(CommentPanelState.None);
                    z17 = false;
                } else {
                    z17 = true;
                }
            }
            z16 = false;
            if (z16) {
                super.onReceivePagerEvent(str, eVar);
                closePage(false, "", false);
                return;
            }
            return;
        }
        super.onReceivePagerEvent(str, eVar);
    }

    public final void closePage(boolean z16, String str, boolean z17) {
        String str2;
        boolean isBlank;
        String str3;
        CharSequence replaceRange;
        if (z16) {
            this.submitted = z16;
        }
        KLog.INSTANCE.d("NearbyFeedCommentInputPage", "onClose: submit=" + z16 + ", text=" + str);
        NBPFeedCommentInputOpenEvent nBPFeedCommentInputOpenEvent = this.data;
        if (nBPFeedCommentInputOpenEvent == null) {
            return;
        }
        if (z16) {
            if (z17) {
                str3 = str;
            } else {
                str3 = str;
                int i3 = 0;
                while (i3 < str3.length() - 1) {
                    if (str3.charAt(i3) == 20) {
                        i3++;
                        char charAt = str3.charAt(i3);
                        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                        QQKuiklyPlatformApi qQKuiklyPlatformApi = (QQKuiklyPlatformApi) c.f117352a.g().acquireModule("QQKuiklyPlatformApi");
                        qQKuiklyPlatformApi.getClass();
                        e eVar = new e();
                        eVar.t("lid", charAt);
                        Unit unit = Unit.INSTANCE;
                        String syncCallNativeMethod = qQKuiklyPlatformApi.syncCallNativeMethod("getQQEmojiNameByLid", eVar, null);
                        if (syncCallNativeMethod.length() > 0) {
                            replaceRange = StringsKt__StringsKt.replaceRange((CharSequence) str3, i3, i3 + 1, (CharSequence) syncCallNativeMethod);
                            str3 = replaceRange.toString();
                            i3 += syncCallNativeMethod.length() - 1;
                        }
                    }
                    i3++;
                }
            }
            DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0.m("will send text:", str3, KLog.INSTANCE, "CR7");
            k kVar = (k) c.f117352a.g().acquireModule("KRNotifyModule");
            e json = nBPFeedCommentInputOpenEvent.toJson();
            json.w("submit", true);
            json.v("input_text", str3);
            json.w("is_quick_comment", z17);
            k.d(kVar, "NBPFeedCommentInputSubmitEvent", json, false, 4, null);
        } else {
            k kVar2 = (k) c.f117352a.g().acquireModule("KRNotifyModule");
            e json2 = nBPFeedCommentInputOpenEvent.toJson();
            json2.w("submit", false);
            json2.v("input_text", "");
            json2.w("is_quick_comment", z17);
            k.d(kVar2, "NBPFeedCommentInputSubmitEvent", json2, false, 4, null);
        }
        NBPFeedCommentInputOpenEvent nBPFeedCommentInputOpenEvent2 = this.data;
        if (nBPFeedCommentInputOpenEvent2 != null && (str2 = nBPFeedCommentInputOpenEvent2.feedId) != null) {
            if (!this.submitted) {
                isBlank = StringsKt__StringsJVMKt.isBlank(str);
                if (!isBlank) {
                    getLruCache().add(str2, str);
                } else {
                    getLruCache().remove(str2);
                }
            } else {
                getLruCache().remove(str2);
            }
        }
        QQKuiklyPlatformApi.Companion companion2 = QQKuiklyPlatformApi.Companion;
        QQKuiklyPlatformApi.Companion.closePage$default();
    }
}
