package com.tencent.mobileqq.qqecommerce.biz.messagecenter;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.data.data_source.message.MessageLocalDataSource;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.data.repository.MessageRepositoryImpl;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.data.repository.MessageSettingsRepositoryImpl;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.data.repository.PromotionRepositoryImpl;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.utils.CacheDelegateKt;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.utils.a;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import tl.h;
import xf2.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b,\u0010-R\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\f\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u0011\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0016\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u001b\u001a\u00020\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001f\u001a\u00020\u001c8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010#\u001a\u00020 8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u0004\u001a\u0004\b!\u0010\"R\u001b\u0010'\u001a\u00020$8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010\u0004\u001a\u0004\b%\u0010&R\u001b\u0010+\u001a\u00020(8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010\u0004\u001a\u0004\b)\u0010*\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/MessageCenterModule;", "", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/data/data_source/message/MessageLocalDataSource;", "b", "Lkotlin/Lazy;", "g", "()Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/data/data_source/message/MessageLocalDataSource;", "messageLocalDataSource", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/data/data_source/message/a;", "c", h.F, "()Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/data/data_source/message/a;", "messageRemoteDataSource", "Lxf2/a;", "d", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lxf2/a;", "promotionLocalDataSource", "Lxf2/b;", "e", DomainData.DOMAIN_NAME, "()Lxf2/b;", "promotionRemoteDataSource", "Lyf2/a;", "f", "k", "()Lyf2/a;", "msgSettingLocalDataSource", "Lyf2/b;", "l", "()Lyf2/b;", "msgSettingRemoteDataSource", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/data/repository/MessageRepositoryImpl;", "i", "()Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/data/repository/MessageRepositoryImpl;", "messageRepositoryImpl", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/data/repository/MessageSettingsRepositoryImpl;", "j", "()Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/data/repository/MessageSettingsRepositoryImpl;", "messageSettingsRepositoryImpl", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/data/repository/PromotionRepositoryImpl;", "o", "()Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/data/repository/PromotionRepositoryImpl;", "promotionRepositoryImpl", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class MessageCenterModule {

    /* renamed from: a, reason: collision with root package name */
    public static final MessageCenterModule f263229a = new MessageCenterModule();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Lazy messageLocalDataSource = new a(new Function0<MessageLocalDataSource>() { // from class: com.tencent.mobileqq.qqecommerce.biz.messagecenter.MessageCenterModule$messageLocalDataSource$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MessageLocalDataSource invoke() {
            return new MessageLocalDataSource();
        }
    }, CacheDelegateKt.a());

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final Lazy messageRemoteDataSource = new a(new Function0<com.tencent.mobileqq.qqecommerce.biz.messagecenter.data.data_source.message.a>() { // from class: com.tencent.mobileqq.qqecommerce.biz.messagecenter.MessageCenterModule$messageRemoteDataSource$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final com.tencent.mobileqq.qqecommerce.biz.messagecenter.data.data_source.message.a invoke() {
            return new com.tencent.mobileqq.qqecommerce.biz.messagecenter.data.data_source.message.a();
        }
    }, CacheDelegateKt.a());

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final Lazy promotionLocalDataSource = new a(new Function0<xf2.a>() { // from class: com.tencent.mobileqq.qqecommerce.biz.messagecenter.MessageCenterModule$promotionLocalDataSource$2
        @Override // kotlin.jvm.functions.Function0
        public final xf2.a invoke() {
            return new xf2.a();
        }
    }, CacheDelegateKt.a());

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final Lazy promotionRemoteDataSource = new a(new Function0<b>() { // from class: com.tencent.mobileqq.qqecommerce.biz.messagecenter.MessageCenterModule$promotionRemoteDataSource$2
        @Override // kotlin.jvm.functions.Function0
        public final b invoke() {
            return new b();
        }
    }, CacheDelegateKt.a());

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final Lazy msgSettingLocalDataSource = new a(new Function0<yf2.a>() { // from class: com.tencent.mobileqq.qqecommerce.biz.messagecenter.MessageCenterModule$msgSettingLocalDataSource$2
        @Override // kotlin.jvm.functions.Function0
        public final yf2.a invoke() {
            return new yf2.a();
        }
    }, CacheDelegateKt.a());

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static final Lazy msgSettingRemoteDataSource = new a(new Function0<yf2.b>() { // from class: com.tencent.mobileqq.qqecommerce.biz.messagecenter.MessageCenterModule$msgSettingRemoteDataSource$2
        @Override // kotlin.jvm.functions.Function0
        public final yf2.b invoke() {
            return new yf2.b();
        }
    }, CacheDelegateKt.a());

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static final Lazy messageRepositoryImpl = new a(new Function0<MessageRepositoryImpl>() { // from class: com.tencent.mobileqq.qqecommerce.biz.messagecenter.MessageCenterModule$messageRepositoryImpl$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MessageRepositoryImpl invoke() {
            MessageLocalDataSource g16;
            com.tencent.mobileqq.qqecommerce.biz.messagecenter.data.data_source.message.a h16;
            MessageCenterModule messageCenterModule = MessageCenterModule.f263229a;
            g16 = messageCenterModule.g();
            h16 = messageCenterModule.h();
            return new MessageRepositoryImpl(g16, h16, null, 4, null);
        }
    }, CacheDelegateKt.a());

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static final Lazy messageSettingsRepositoryImpl = new a(new Function0<MessageSettingsRepositoryImpl>() { // from class: com.tencent.mobileqq.qqecommerce.biz.messagecenter.MessageCenterModule$messageSettingsRepositoryImpl$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MessageSettingsRepositoryImpl invoke() {
            yf2.a k3;
            yf2.b l3;
            MessageCenterModule messageCenterModule = MessageCenterModule.f263229a;
            k3 = messageCenterModule.k();
            l3 = messageCenterModule.l();
            return new MessageSettingsRepositoryImpl(k3, l3, null, 4, null);
        }
    }, CacheDelegateKt.a());

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private static final Lazy promotionRepositoryImpl = new a(new Function0<PromotionRepositoryImpl>() { // from class: com.tencent.mobileqq.qqecommerce.biz.messagecenter.MessageCenterModule$promotionRepositoryImpl$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final PromotionRepositoryImpl invoke() {
            xf2.a m3;
            b n3;
            MessageCenterModule messageCenterModule = MessageCenterModule.f263229a;
            m3 = messageCenterModule.m();
            n3 = messageCenterModule.n();
            return new PromotionRepositoryImpl(m3, n3, null, 4, null);
        }
    }, CacheDelegateKt.a());

    MessageCenterModule() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MessageLocalDataSource g() {
        return (MessageLocalDataSource) messageLocalDataSource.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.qqecommerce.biz.messagecenter.data.data_source.message.a h() {
        return (com.tencent.mobileqq.qqecommerce.biz.messagecenter.data.data_source.message.a) messageRemoteDataSource.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final yf2.a k() {
        return (yf2.a) msgSettingLocalDataSource.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final yf2.b l() {
        return (yf2.b) msgSettingRemoteDataSource.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final xf2.a m() {
        return (xf2.a) promotionLocalDataSource.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b n() {
        return (b) promotionRemoteDataSource.getValue();
    }

    public final MessageRepositoryImpl i() {
        return (MessageRepositoryImpl) messageRepositoryImpl.getValue();
    }

    public final MessageSettingsRepositoryImpl j() {
        return (MessageSettingsRepositoryImpl) messageSettingsRepositoryImpl.getValue();
    }

    public final PromotionRepositoryImpl o() {
        return (PromotionRepositoryImpl) promotionRepositoryImpl.getValue();
    }
}
