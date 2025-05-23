package com.tencent.mobileqq.vas.api.impl;

import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vas.VipMMKV;
import com.tencent.mobileqq.vas.api.IVasLiangNum;
import com.tencent.mobileqq.vas.api.impl.VasLiangNumImpl;
import com.tencent.mobileqq.vas.liangnum.AbsLiangNumDrawable;
import com.tencent.mobileqq.vas.liangnum.NormalLiangNumDrawable;
import com.tencent.mobileqq.vas.liangnum.XuanCaiLiangNumDrawable;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.entity.UpdateListenerParams;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J:\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0015H\u0016J\u001c\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00172\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0019R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/vas/api/impl/VasLiangNumImpl;", "Lcom/tencent/mobileqq/vas/api/IVasLiangNum;", "", "uin", "genKey", "", "isEnable", "", "getSelfLiangId", "newId", "", "saveLiangNumId", "Lcom/tencent/mobileqq/vas/api/IVasLiangNum$b;", "l", "registerLiangIdChangedListener", "unregisterLiangIdChangedListener", "Landroid/view/View;", "view", "id", "viewHeight", "scene", "Lcom/tencent/mobileqq/vas/api/IVasLiangNum$c;", "setLiangNumDrawable", "Lkotlin/Pair;", "getPresettingWH", "Z", "Ljava/util/concurrent/CopyOnWriteArrayList;", "listenerList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "<init>", "()V", "Companion", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasLiangNumImpl implements IVasLiangNum {

    @NotNull
    private static final String TAG = "VasLiangNumImpl";
    private final boolean isEnable = com.tencent.mobileqq.vas.ar.INSTANCE.b("shouyouye", "2024-12-24", "vas_liang_nameplate_config").isEnable(true);

    @NotNull
    private final CopyOnWriteArrayList<IVasLiangNum.b> listenerList = new CopyOnWriteArrayList<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/vas/api/impl/VasLiangNumImpl$b", "Lcom/tencent/mobileqq/vas/updatesystem/callback/IDownLoadListener;", "Lcom/tencent/vas/update/entity/UpdateListenerParams;", "params", "", "onLoadSuccess", "onLoadFail", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b implements IDownLoadListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f308533b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f308534c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f308535d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f308536e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f308537f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ IVasLiangNum.c f308538g;

        b(View view, int i3, int i16, String str, String str2, IVasLiangNum.c cVar) {
            this.f308533b = view;
            this.f308534c = i3;
            this.f308535d = i16;
            this.f308536e = str;
            this.f308537f = str2;
            this.f308538g = cVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(VasLiangNumImpl this$0, View view, int i3, int i16, String uin, String scene, IVasLiangNum.c cVar) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(view, "$view");
            Intrinsics.checkNotNullParameter(uin, "$uin");
            Intrinsics.checkNotNullParameter(scene, "$scene");
            this$0.setLiangNumDrawable(view, i3, i16, uin, scene, cVar);
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadFail(@NotNull UpdateListenerParams params) {
            Intrinsics.checkNotNullParameter(params, "params");
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadSuccess(@NotNull UpdateListenerParams params) {
            Intrinsics.checkNotNullParameter(params, "params");
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final VasLiangNumImpl vasLiangNumImpl = VasLiangNumImpl.this;
            final View view = this.f308533b;
            final int i3 = this.f308534c;
            final int i16 = this.f308535d;
            final String str = this.f308536e;
            final String str2 = this.f308537f;
            final IVasLiangNum.c cVar = this.f308538g;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.vas.api.impl.am
                @Override // java.lang.Runnable
                public final void run() {
                    VasLiangNumImpl.b.b(VasLiangNumImpl.this, view, i3, i16, str, str2, cVar);
                }
            });
        }
    }

    private final String genKey(String uin) {
        return "vas_haoma_nameplate_" + uin;
    }

    @Override // com.tencent.mobileqq.vas.api.IVasLiangNum
    @NotNull
    public Pair<Integer, Integer> getPresettingWH(@NotNull String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Pair<Integer, Integer> pair = AbsLiangNumDrawable.INSTANCE.a().get(Integer.valueOf(uin.length()));
        if (pair == null) {
            return new Pair<>(0, 0);
        }
        return pair;
    }

    @Override // com.tencent.mobileqq.vas.api.IVasLiangNum
    public int getSelfLiangId() {
        String currentAccountUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin();
        Intrinsics.checkNotNullExpressionValue(currentAccountUin, "sMobileQQ.peekAppRuntime().currentAccountUin");
        int decodeInt = VipMMKV.INSTANCE.getLiangNamePlate().decodeInt(genKey(currentAccountUin), 0);
        QLog.i(TAG, 1, "getSelfLiangId: " + decodeInt);
        return decodeInt;
    }

    @Override // com.tencent.mobileqq.vas.api.IVasLiangNum
    /* renamed from: isEnable, reason: from getter */
    public boolean getIsEnable() {
        return this.isEnable;
    }

    @Override // com.tencent.mobileqq.vas.api.IVasLiangNum
    public void registerLiangIdChangedListener(@NotNull IVasLiangNum.b l3) {
        Intrinsics.checkNotNullParameter(l3, "l");
        if (this.listenerList.contains(l3)) {
            return;
        }
        this.listenerList.add(l3);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasLiangNum
    public void saveLiangNumId(@NotNull String uin, int newId) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        String genKey = genKey(uin);
        VipMMKV.Companion companion = VipMMKV.INSTANCE;
        int decodeInt = companion.getLiangNamePlate().decodeInt(genKey, 0);
        if (decodeInt != newId) {
            companion.getLiangNamePlate().encodeInt(genKey, newId);
            Iterator<T> it = this.listenerList.iterator();
            while (it.hasNext()) {
                ((IVasLiangNum.b) it.next()).onChanged();
            }
        }
        QLog.i(TAG, 1, "saveLiangNumId cache: " + decodeInt + " newId: " + newId);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasLiangNum
    public void setLiangNumDrawable(@NotNull View view, int id5, int viewHeight, @NotNull String uin, @NotNull String scene, @Nullable IVasLiangNum.c l3) {
        AbsLiangNumDrawable xuanCaiLiangNumDrawable;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(scene, "scene");
        QQVasUpdateBusiness<?> business = QQVasUpdateBusiness.getBusiness(350L);
        if (business.isFileExists(id5)) {
            com.tencent.mobileqq.vas.liangnum.c cVar = com.tencent.mobileqq.vas.liangnum.c.f309987a;
            Intrinsics.checkNotNullExpressionValue(business, "business");
            if (cVar.a(id5, business)) {
                xuanCaiLiangNumDrawable = new NormalLiangNumDrawable(id5, uin, viewHeight, view, business, scene);
            } else {
                xuanCaiLiangNumDrawable = new XuanCaiLiangNumDrawable(id5, uin, viewHeight, view, business, scene);
            }
            xuanCaiLiangNumDrawable.U();
            view.setBackground(xuanCaiLiangNumDrawable);
            if (l3 != null) {
                l3.a();
                return;
            }
            return;
        }
        business.addDownLoadListener(id5, new b(view, id5, viewHeight, uin, scene, l3));
        business.startDownload(id5);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasLiangNum
    public void unregisterLiangIdChangedListener(@NotNull IVasLiangNum.b l3) {
        Intrinsics.checkNotNullParameter(l3, "l");
        this.listenerList.remove(l3);
    }
}
