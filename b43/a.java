package b43;

import com.tencent.mobileqq.kandian.base.report.ReadInJoyMMapKvStorage;
import com.tencent.mobileqq.qqgift.api.countdown.IQQGiftCountDownModule;
import nh2.c;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a implements IQQGiftCountDownModule {

    /* renamed from: a, reason: collision with root package name */
    private c f27870a;

    /* renamed from: b, reason: collision with root package name */
    IQQGiftCountDownModule.CountDownStrategy f27871b = IQQGiftCountDownModule.CountDownStrategy.COUNT_DOWN_ROOM;

    private String Y() {
        com.tencent.mobileqq.qqgift.sdk.config.a sDKConfig;
        c cVar = this.f27870a;
        if (cVar != null && (sDKConfig = cVar.getSDKConfig()) != null) {
            return sDKConfig.f264972a + "";
        }
        return ReadInJoyMMapKvStorage.NAME_DEFAULT;
    }

    @Override // nh2.a
    public void N(c cVar) {
        this.f27870a = cVar;
    }

    @Override // com.tencent.mobileqq.qqgift.api.countdown.IQQGiftCountDownModule
    public void enterRoom() {
        if (IQQGiftCountDownModule.CountDownStrategy.COUNT_DOWN_ROOM.equals(this.f27871b)) {
            e43.a.d().a(Y());
        }
    }

    @Override // com.tencent.mobileqq.qqgift.api.countdown.IQQGiftCountDownModule
    public void exitRoom() {
        if (IQQGiftCountDownModule.CountDownStrategy.COUNT_DOWN_ROOM.equals(this.f27871b)) {
            e43.a.d().b(Y());
        }
    }

    @Override // com.tencent.mobileqq.qqgift.api.countdown.IQQGiftCountDownModule
    public void j(IQQGiftCountDownModule.CountDownStrategy countDownStrategy) {
        this.f27871b = countDownStrategy;
    }

    @Override // com.tencent.mobileqq.qqgift.api.countdown.IQQGiftCountDownModule
    public IQQGiftCountDownModule.CountDownStrategy q() {
        return this.f27871b;
    }

    @Override // nh2.a
    public void destroy() {
    }
}
