package com.tencent.timi.game.userinfo.impl.db;

import com.tencent.timi.game.databasecore.impl.livedata.BaseDbLiveData;
import com.tencent.timi.game.databasecore.impl.livedata.LoadDataWrapper;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.utils.IResultListener;
import io4.k;
import io4.n;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass$QQUserId;

/* compiled from: P */
/* loaded from: classes26.dex */
public class UserInfoLiveData extends BaseDbLiveData<do4.b, IUserInfo> {
    private CommonOuterClass$QQUserId C;

    /* renamed from: m, reason: collision with root package name */
    private boolean f380185m = false;
    tg4.b D = new c();

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class c implements tg4.b<IUserInfo> {
        c() {
        }

        @Override // tg4.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@Nullable IUserInfo iUserInfo) {
            if (iUserInfo != null && iUserInfo.e(UserInfoLiveData.this.C)) {
                UserInfoLiveData.this.l(iUserInfo, 4);
            }
        }
    }

    public UserInfoLiveData(CommonOuterClass$QQUserId commonOuterClass$QQUserId) {
        this.C = commonOuterClass$QQUserId;
        k.f408119a.s(this.C, new a());
    }

    @Override // com.tencent.timi.game.databasecore.impl.livedata.BaseDbLiveData
    protected void f(sg4.b<do4.b> bVar) {
        n.f408123a.g(this.D);
    }

    @Override // com.tencent.timi.game.databasecore.impl.livedata.BaseDbLiveData
    protected void h(sg4.b<do4.b> bVar) {
        n.f408123a.j(this.D);
    }

    public boolean k() {
        return this.f380185m;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void l(IUserInfo iUserInfo, int i3) {
        LoadDataWrapper value = getValue();
        if (value == null) {
            value = new LoadDataWrapper(i3, iUserInfo);
        } else {
            value.f376796c = i3;
            value.f376797d = iUserInfo;
        }
        setValue(value);
    }

    public void m(int i3, String str) {
        k.f408119a.s(this.C, new b(i3, str));
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements IResultListener<IUserInfo> {
        a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(IUserInfo iUserInfo) {
            if (iUserInfo != 0) {
                LoadDataWrapper loadDataWrapper = new LoadDataWrapper(1, null);
                loadDataWrapper.f376796c = 4;
                loadDataWrapper.f376797d = iUserInfo;
                UserInfoLiveData.this.f380185m = true;
                UserInfoLiveData.this.setValue(loadDataWrapper);
            }
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int i3, String str) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class b implements IResultListener<IUserInfo> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f380187a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f380188b;

        b(int i3, String str) {
            this.f380187a = i3;
            this.f380188b = str;
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(IUserInfo iUserInfo) {
            UserInfoLiveData.this.setValue(LoadDataWrapper.a(this.f380187a, this.f380188b, iUserInfo));
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int i3, String str) {
        }
    }
}
