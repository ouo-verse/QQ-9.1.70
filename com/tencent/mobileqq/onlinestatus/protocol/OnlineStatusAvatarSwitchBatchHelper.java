package com.tencent.mobileqq.onlinestatus.protocol;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.onlinestatus.model.f;
import com.tencent.qphone.base.util.QLog;
import com.tencent.state.data.SquareJSConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000e2\u00020\u0001:\u0002\u000f\u0015B\u0015\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\u0016\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fR\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R0\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001b0\u001aj\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001b`\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001dR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u001fR\u0016\u0010\"\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0003\u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/protocol/OnlineStatusAvatarSwitchBatchHelper;", "", "", "f", "", "success", "e", "", "", "d", "Lcom/tencent/common/app/AppInterface;", "appInterface", "Lcom/tencent/mobileqq/onlinestatus/protocol/OnlineStatusAvatarSwitchBatchHelper$a;", "callback", "g", "a", "Ljava/util/List;", "getUinList", "()Ljava/util/List;", SquareJSConst.Params.PARAMS_UIN_LIST, "", "b", "I", "nextUpdateUinIndex", "c", "Lcom/tencent/mobileqq/onlinestatus/protocol/OnlineStatusAvatarSwitchBatchHelper$a;", "Ljava/util/HashMap;", "Lcom/tencent/mobileqq/onlinestatus/model/f;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "switchMap", "Lcom/tencent/common/app/AppInterface;", "Lcom/tencent/mobileqq/onlinestatus/protocol/a;", "Lcom/tencent/mobileqq/onlinestatus/protocol/a;", "handler", "<init>", "(Ljava/util/List;)V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class OnlineStatusAvatarSwitchBatchHelper {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Long> uinList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int nextUpdateUinIndex;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a callback;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Long, f> switchMap;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private AppInterface appInterface;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.onlinestatus.protocol.a handler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/protocol/OnlineStatusAvatarSwitchBatchHelper$a;", "", "", "success", "", "", "Lcom/tencent/mobileqq/onlinestatus/model/f;", "switchMap", "", "a", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public interface a {
        void a(boolean success, @NotNull Map<Long, f> switchMap);
    }

    public OnlineStatusAvatarSwitchBatchHelper(@NotNull List<Long> uinList) {
        Intrinsics.checkNotNullParameter(uinList, "uinList");
        this.uinList = uinList;
        this.switchMap = new HashMap<>();
    }

    private final List<Long> d() {
        ArrayList arrayList = new ArrayList(200);
        for (int i3 = 0; i3 < 200 && this.nextUpdateUinIndex < this.uinList.size(); i3++) {
            List<Long> list = this.uinList;
            int i16 = this.nextUpdateUinIndex;
            this.nextUpdateUinIndex = i16 + 1;
            arrayList.add(list.get(i16));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(boolean success) {
        if (QLog.isColorLevel()) {
            QLog.i("OnlineStatusAvatar.SwitchBatchHelper", 2, "[notify] success=" + success + ", uinCount=" + this.uinList.size() + "->" + this.switchMap.size());
        }
        a aVar = this.callback;
        if (aVar != null) {
            aVar.a(success, this.switchMap);
        }
        this.callback = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f() {
        List<Long> d16 = d();
        if (d16.isEmpty()) {
            e(true);
            return;
        }
        com.tencent.mobileqq.onlinestatus.protocol.a aVar = this.handler;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("handler");
            aVar = null;
        }
        aVar.a(d16, new Function2<Boolean, Map<Long, ? extends f>, Unit>() { // from class: com.tencent.mobileqq.onlinestatus.protocol.OnlineStatusAvatarSwitchBatchHelper$sendRequest$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Map<Long, ? extends f> map) {
                invoke(bool.booleanValue(), (Map<Long, f>) map);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, @NotNull Map<Long, f> rspSwitchMap) {
                HashMap hashMap;
                Intrinsics.checkNotNullParameter(rspSwitchMap, "rspSwitchMap");
                if (!z16) {
                    OnlineStatusAvatarSwitchBatchHelper.this.e(false);
                    return;
                }
                hashMap = OnlineStatusAvatarSwitchBatchHelper.this.switchMap;
                hashMap.putAll(rspSwitchMap);
                OnlineStatusAvatarSwitchBatchHelper.this.f();
            }
        });
    }

    public final void g(@NotNull AppInterface appInterface, @NotNull a callback) {
        Intrinsics.checkNotNullParameter(appInterface, "appInterface");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (this.nextUpdateUinIndex == 0) {
            this.callback = callback;
            this.appInterface = appInterface;
            this.handler = new com.tencent.mobileqq.onlinestatus.protocol.a(appInterface);
            f();
            return;
        }
        throw new IllegalStateException("batch update operation is already started");
    }
}
