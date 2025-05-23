package com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.HotViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.lib.UriKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQUIModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.CheckIdentityRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.CommonProxyService;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.StrangerFeedCommentRepo;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.StrangerFeedCommentRepoKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.AsyncTaskTracker;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyProCommentUtils;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.app.face.FaceConstant;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsJVMKt;
import org.apache.httpcore.message.TokenParser;
import p35.b;

/* loaded from: classes31.dex */
public final class NBPFeedCommentExtraViewModel implements INBPFeedCommentExtraHandler {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPFeedCommentExtraViewModel.class, "menuVisible", "getMenuVisible()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPFeedCommentExtraViewModel.class, "identityDialogVisible", "getIdentityDialogVisible()Z", 0)};
    public final int appId;
    public final StrangerFeedCommentRepo commentRepo;
    public NBPFeedCommentDeleteConfirmOpenEvent deleteConfirmOpenData;
    public AsyncTaskTracker<b> identityCheckTask = new AsyncTaskTracker<>();
    public final ReadWriteProperty identityDialogVisible$delegate;
    public final NBPFeedCommentExtraManager manager;
    public NBPFeedCommentMenuOpenEvent menuOpenData;
    public final ReadWriteProperty menuVisible$delegate;
    public boolean userInIdentifying;

    public NBPFeedCommentExtraViewModel(int i3, String str) {
        this.appId = i3;
        this.commentRepo = new StrangerFeedCommentRepo(i3);
        this.manager = new NBPFeedCommentExtraManager(str, this);
        Boolean bool = Boolean.FALSE;
        this.menuVisible$delegate = c.a(bool);
        this.identityDialogVisible$delegate = c.a(bool);
        loadUserIdentity();
    }

    public final void closeIdentityDialog(boolean z16) {
        this.identityDialogVisible$delegate.setValue(this, $$delegatedProperties[1], Boolean.FALSE);
        if (z16) {
            this.userInIdentifying = true;
            this.identityCheckTask.executeOnDone(false, new Function1<b, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentExtraViewModel$closeIdentityDialog$1
                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(b bVar) {
                    String str;
                    b bVar2 = bVar;
                    if (bVar2 != null && (str = bVar2.f425151f) != null) {
                        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                        QQKuiklyPlatformApi.Companion.openPage$default(str, false, 6);
                    }
                    return Unit.INSTANCE;
                }
            });
        }
    }

    public final void closeMenu(NBPFeedCommentMenuItem nBPFeedCommentMenuItem) {
        this.menuVisible$delegate.setValue(this, $$delegatedProperties[0], Boolean.FALSE);
        NBPFeedCommentMenuOpenEvent nBPFeedCommentMenuOpenEvent = this.menuOpenData;
        if (nBPFeedCommentMenuOpenEvent != null) {
            k kVar = (k) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("KRNotifyModule");
            e eVar = new e();
            eVar.v("openData", nBPFeedCommentMenuOpenEvent.toJson());
            eVar.t("action", nBPFeedCommentMenuItem.ordinal());
            k.d(kVar, "NBPFeedCommentMenuClickEvent", eVar, false, 4, null);
            this.menuOpenData = null;
        }
    }

    public final boolean getIdentityDialogVisible() {
        return ((Boolean) this.identityDialogVisible$delegate.getValue(this, $$delegatedProperties[1])).booleanValue();
    }

    public final boolean getMenuVisible() {
        return ((Boolean) this.menuVisible$delegate.getValue(this, $$delegatedProperties[0])).booleanValue();
    }

    public final void loadUserIdentity() {
        this.identityCheckTask.reset(true);
        if (!NearbyProCommentUtils.INSTANCE.needCheckIdentity()) {
            KLog.INSTANCE.i("NBPFeedCommentExtraViewModel", "checkIdentityInfo skip");
            this.identityCheckTask.markDone(new b(null, 0, null, 7, null));
            return;
        }
        StrangerFeedCommentRepo strangerFeedCommentRepo = this.commentRepo;
        final Function3<b, Integer, String, Unit> function3 = new Function3<b, Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentExtraViewModel$loadUserIdentity$1
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(b bVar, Integer num, String str) {
                b bVar2 = bVar;
                int intValue = num.intValue();
                String str2 = str;
                if (intValue != 0) {
                    KLog.INSTANCE.e("NBPFeedCommentExtraViewModel", "checkIdentityInfo error: " + intValue + TokenParser.SP + str2);
                    if (intValue == 10000) {
                        NBPFeedCommentExtraViewModel nBPFeedCommentExtraViewModel = NBPFeedCommentExtraViewModel.this;
                        if (nBPFeedCommentExtraViewModel.appId == 1) {
                            nBPFeedCommentExtraViewModel.identityCheckTask.markDone(new b(null, 0, null, 7, null));
                        }
                    }
                    NBPFeedCommentExtraViewModel.this.identityCheckTask.markDone(null);
                } else {
                    KLog kLog = KLog.INSTANCE;
                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("checkIdentityInfo done: ");
                    m3.append(bVar2 != null ? Integer.valueOf(bVar2.f425150e) : null);
                    m3.append(TokenParser.SP);
                    AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m3, bVar2 != null ? bVar2.f425151f : null, kLog, "NBPFeedCommentExtraViewModel");
                    NBPFeedCommentExtraViewModel.this.identityCheckTask.markDone(bVar2);
                }
                return Unit.INSTANCE;
            }
        };
        strangerFeedCommentRepo.getClass();
        KLog.INSTANCE.i("StrangerFeedCommentRepo", "checkIdentity");
        CommonProxyService.INSTANCE.request(new CheckIdentityRequest(strangerFeedCommentRepo.appId), new Function4<b, byte[], Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.repo.StrangerFeedCommentRepo$checkIdentity$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public final Unit invoke(b bVar, byte[] bArr, Integer num, String str) {
                b bVar2 = bVar;
                int intValue = num.intValue();
                String str2 = str;
                KLog kLog = KLog.INSTANCE;
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("checkIdentity: rspIsNull=");
                m3.append(bVar2 == null);
                m3.append(" code=");
                m3.append(intValue);
                m3.append(", msg=");
                AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m3, str2, kLog, "StrangerFeedCommentRepo");
                function3.invoke(bVar2, Integer.valueOf(intValue), str2);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.INBPFeedCommentExtraHandler
    public final void onDeleteConfirmOpen(NBPFeedCommentDeleteConfirmOpenEvent nBPFeedCommentDeleteConfirmOpenEvent) {
        this.deleteConfirmOpenData = nBPFeedCommentDeleteConfirmOpenEvent;
        ((QQUIModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("QQUIModule")).openAlertDialog("", "\u786e\u5b9a\u8981\u5220\u9664\u8fd9\u6761\u8bc4\u8bba", "\u518d\u60f3\u60f3", "\u786e\u5b9a", "", false, new Function2<Boolean, Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentExtraViewModel$onDeleteConfirmOpen$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Boolean bool, Boolean bool2) {
                NBPFeedCommentExtraViewModel nBPFeedCommentExtraViewModel;
                NBPFeedCommentDeleteConfirmOpenEvent nBPFeedCommentDeleteConfirmOpenEvent2;
                boolean booleanValue = bool.booleanValue();
                bool2.booleanValue();
                if (booleanValue && (nBPFeedCommentDeleteConfirmOpenEvent2 = (nBPFeedCommentExtraViewModel = NBPFeedCommentExtraViewModel.this).deleteConfirmOpenData) != null) {
                    k kVar = (k) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("KRNotifyModule");
                    e eVar = new e();
                    eVar.v("openData", nBPFeedCommentDeleteConfirmOpenEvent2.toJson());
                    eVar.w(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, true);
                    k.d(kVar, "NBPFeedCommentDeleteConfirmClickEvent", eVar, false, 4, null);
                    nBPFeedCommentExtraViewModel.deleteConfirmOpenData = null;
                }
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.INBPFeedCommentExtraHandler
    public final void onInputOpen(final NBPFeedCommentInputOpenEvent nBPFeedCommentInputOpenEvent) {
        this.identityCheckTask.executeOnDone(true, new Function1<b, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.NBPFeedCommentExtraViewModel$onInputOpen$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(b bVar) {
                byte[] encodeToByteArray;
                byte[] encodeToByteArray2;
                b bVar2 = bVar;
                if (bVar2 == null) {
                    Utils.INSTANCE.currentBridgeModule().qToast("\u5b9e\u540d\u8ba4\u8bc1\u68c0\u67e5\u4e2d\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", QToastMode.Info);
                    NBPFeedCommentExtraViewModel.this.loadUserIdentity();
                } else {
                    if (bVar2.f425150e == 0) {
                        NBPFeedCommentInputOpenEvent nBPFeedCommentInputOpenEvent2 = nBPFeedCommentInputOpenEvent;
                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("mqqapi://kuikly/open?version=1&src_type=app&modal_mode=1&page_name=nearby_feed_comment_input&custom_back_pressed=1&request_id=");
                        m3.append(UriKt.encodeURIComponent(nBPFeedCommentInputOpenEvent2.requestId));
                        m3.append("&app_id=");
                        m3.append(nBPFeedCommentInputOpenEvent2.appId);
                        m3.append("&pager_id=");
                        m3.append(nBPFeedCommentInputOpenEvent2.pagerId);
                        m3.append("&feed_id=");
                        m3.append(UriKt.encodeURIComponent(nBPFeedCommentInputOpenEvent2.feedId));
                        m3.append("&panel_state=");
                        m3.append(nBPFeedCommentInputOpenEvent2.panelState.ordinal());
                        String sb5 = m3.toString();
                        DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0.m("jumpFeedCommentInputPage: ", sb5, KLog.INSTANCE, "NBPJumpUtil");
                        String str = nBPFeedCommentInputOpenEvent2.targetCommentId;
                        if (str != null) {
                            StringBuilder m16 = HotViewKt$$ExternalSyntheticOutline0.m(sb5, "&target_comment_id=");
                            m16.append(UriKt.encodeURIComponent(str));
                            sb5 = m16.toString();
                        }
                        String str2 = nBPFeedCommentInputOpenEvent2.targetReplyId;
                        if (str2 != null) {
                            StringBuilder m17 = HotViewKt$$ExternalSyntheticOutline0.m(sb5, "&target_reply_id=");
                            m17.append(UriKt.encodeURIComponent(str2));
                            sb5 = m17.toString();
                        }
                        String str3 = nBPFeedCommentInputOpenEvent2.targetUserNickname;
                        if (str3 != null) {
                            StringBuilder m18 = HotViewKt$$ExternalSyntheticOutline0.m(sb5, "&target_user_nickname=");
                            m18.append(UriKt.encodeURIComponent(str3));
                            sb5 = m18.toString();
                        }
                        encodeToByteArray = StringsKt__StringsJVMKt.encodeToByteArray(StrangerFeedCommentRepoKt.toJSON(nBPFeedCommentInputOpenEvent2.quickComments).toString());
                        encodeToByteArray2 = StringsKt__StringsJVMKt.encodeToByteArray(StrangerFeedCommentRepoKt.toJSON(nBPFeedCommentInputOpenEvent2.aiQuickComments).toString());
                        QQNearbyModule.Companion.getInstance().setSharePenetratePageData(new byte[][]{encodeToByteArray, encodeToByteArray2});
                        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                        QQKuiklyPlatformApi.Companion.openPage$default(sb5, false, 4);
                    } else {
                        if (bVar2.f425151f.length() > 0) {
                            NBPFeedCommentExtraViewModel nBPFeedCommentExtraViewModel = NBPFeedCommentExtraViewModel.this;
                            nBPFeedCommentExtraViewModel.identityDialogVisible$delegate.setValue(nBPFeedCommentExtraViewModel, NBPFeedCommentExtraViewModel.$$delegatedProperties[1], Boolean.TRUE);
                        } else {
                            Utils.INSTANCE.currentBridgeModule().qToast("\u5b9e\u540d\u8ba4\u8bc1\u68c0\u67e5\u4e2d\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", QToastMode.Info);
                            NBPFeedCommentExtraViewModel.this.loadUserIdentity();
                        }
                    }
                }
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.INBPFeedCommentExtraHandler
    public final void onMenuOpen(NBPFeedCommentMenuOpenEvent nBPFeedCommentMenuOpenEvent) {
        this.menuOpenData = nBPFeedCommentMenuOpenEvent;
        this.menuVisible$delegate.setValue(this, $$delegatedProperties[0], Boolean.TRUE);
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.INBPFeedCommentExtraHandler
    public final void onDeleteConfirmClick(NBPFeedCommentDeleteConfirmClickEvent nBPFeedCommentDeleteConfirmClickEvent) {
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.INBPFeedCommentExtraHandler
    public final void onInputClosed(NBPFeedCommentInputClosedEvent nBPFeedCommentInputClosedEvent) {
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.INBPFeedCommentExtraHandler
    public final void onInputOpened() {
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.extra.INBPFeedCommentExtraHandler
    public final void onMenuClick(NBPFeedCommentMenuClickEvent nBPFeedCommentMenuClickEvent) {
    }
}
