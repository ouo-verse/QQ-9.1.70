package com.tencent.mobileqq.icgame.push;

/* compiled from: P */
/* loaded from: classes15.dex */
public class c implements t32.b {

    /* renamed from: a, reason: collision with root package name */
    private int f237412a;

    /* renamed from: b, reason: collision with root package name */
    private ni2.a f237413b;

    /* renamed from: c, reason: collision with root package name */
    private LivePushRepository f237414c;

    public c(LivePushRepository livePushRepository) {
        this.f237414c = livePushRepository;
    }

    @Override // t32.b
    public void a() {
        LivePushRepository livePushRepository = this.f237414c;
        if (livePushRepository != null) {
            livePushRepository.g(this);
        }
        this.f237413b = null;
    }

    @Override // t32.b
    public t32.b b(int i3, ni2.a aVar) {
        this.f237412a = i3;
        this.f237413b = aVar;
        LivePushRepository livePushRepository = this.f237414c;
        if (livePushRepository != null) {
            livePushRepository.b(this);
        }
        return this;
    }

    public ni2.a c() {
        return this.f237413b;
    }

    public int d() {
        return this.f237412a;
    }

    public String toString() {
        return super.toString() + ", RoomPush" + this.f237413b;
    }
}
