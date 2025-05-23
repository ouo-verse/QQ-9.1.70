package com.tencent.sqshow.zootopia.nativeui.adapter.holder;

import android.os.Looper;
import android.text.TextUtils;
import com.google.protobuf.nano.MessageNano;
import com.tencent.filament.zplan.record.FilamentNativeAppRecorder;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.sqshow.zootopia.nativeui.adapter.holder.DressUpItemRecordHelper;
import com.tencent.zplan.common.model.AppTheme;
import com.tencent.zplan.common.model.UploadConfig;
import com.tencent.zplan.meme.EngineType;
import com.tencent.zplan.meme.Priority;
import com.tencent.zplan.meme.action.MODE;
import com.tencent.zplan.meme.model.AvatarCharacterInfo;
import com.tencent.zplan.meme.model.BusinessConfig;
import com.tencent.zplan.record.model.SingleRecordRequestParams;
import com.tencent.zplan.record.model.ZPlanRecordResource;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import mqq.util.WeakReference;
import wk3.PortalStoreDressUpRecordParamConfig;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u00010B\t\b\u0002\u00a2\u0006\u0004\b.\u0010/J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J5\u0010\u000e\u001a\u00028\u0000\"\u0004\b\u0000\u0010\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00028\u0000H\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0011\u001a\u00020\u00102\b\u0010\f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\r\u001a\u00020\u0010H\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J$\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u000b2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014H\u0002J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u000bH\u0002J\u0016\u0010\u001a\u001a\u00020\u00162\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00160\tH\u0002J\u0018\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001d\u001a\u00020\u0010J\u0016\u0010!\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u0015J\u000e\u0010\"\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u0015J\u000e\u0010#\u001a\u00020\u001e2\u0006\u0010\u0013\u001a\u00020\u000bR0\u0010(\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u001e0$j\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u001e`%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'Rh\u0010-\u001aV\u0012\u0004\u0012\u00020\u000b\u0012 \u0012\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150*0)j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150*`+0$j*\u0012\u0004\u0012\u00020\u000b\u0012 \u0012\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150*0)j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150*`+`%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010'\u00a8\u00061"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/adapter/holder/DressUpItemRecordHelper;", "", "Lwk3/b;", "recordConfig", "Lcom/tencent/zplan/meme/model/a;", "avatarCharacterInfo", "Lcom/tencent/zplan/record/model/SingleRecordRequestParams;", tl.h.F, "T", "Lkotlin/Function0;", "callback", "", "originalValue", RemoteHandleConst.PARAM_DEFAULT_VALUE, "l", "(Lkotlin/jvm/functions/Function0;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Ljava/lang/Integer;I)I", "dressKey", "Lkotlin/Function1;", "Lcom/tencent/sqshow/zootopia/nativeui/adapter/holder/DressUpItemRecordHelper$a;", "", "action", "j", "p", "f", "Luv4/ag;", "outfitConfig", "originalPosInList", "", DomainData.DOMAIN_NAME, "listener", "k", "o", "i", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "recordLoadingMap", "Ljava/util/ArrayList;", "Lmqq/util/WeakReference;", "Lkotlin/collections/ArrayList;", "c", "recordListenerMap", "<init>", "()V", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class DressUpItemRecordHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final DressUpItemRecordHelper f370779a = new DressUpItemRecordHelper();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final HashMap<String, Boolean> recordLoadingMap = new HashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final HashMap<String, ArrayList<WeakReference<a>>> recordListenerMap = new HashMap<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/adapter/holder/DressUpItemRecordHelper$a;", "", "", "dressKey", "Lcom/tencent/zplan/record/model/ZPlanRecordResource;", "recordResult", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public interface a {
        void a(String dressKey, ZPlanRecordResource recordResult);
    }

    DressUpItemRecordHelper() {
    }

    private final void f(final Function0<Unit> callback) {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            callback.invoke();
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.adapter.holder.n
                @Override // java.lang.Runnable
                public final void run() {
                    DressUpItemRecordHelper.g(Function0.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(Function0 callback) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(final String dressKey, final Function1<? super a, Unit> action) {
        f(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.nativeui.adapter.holder.DressUpItemRecordHelper$notifyAllExtraListeners$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                HashMap hashMap;
                ArrayList arrayList = new ArrayList();
                hashMap = DressUpItemRecordHelper.recordListenerMap;
                ArrayList arrayList2 = (ArrayList) hashMap.get(dressKey);
                if (arrayList2 != null) {
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        DressUpItemRecordHelper.a aVar = (DressUpItemRecordHelper.a) ((WeakReference) it.next()).get();
                        if (aVar != null) {
                            arrayList.add(aVar);
                        }
                    }
                }
                Function1<DressUpItemRecordHelper.a, Unit> function1 = action;
                Iterator it5 = arrayList.iterator();
                while (it5.hasNext()) {
                    function1.invoke((DressUpItemRecordHelper.a) it5.next());
                }
            }
        });
    }

    private final <T> T l(Function0<? extends T> callback, String originalValue, T defaultValue) {
        try {
            return callback.invoke();
        } catch (Exception unused) {
            QLog.e("DressUpItemViewHolder_DressUpItemRecordHelper", 1, "safeConvertEnum exception - " + originalValue);
            return defaultValue;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(String dressKey) {
        recordListenerMap.remove(dressKey);
    }

    public final boolean i(String dressKey) {
        Intrinsics.checkNotNullParameter(dressKey, "dressKey");
        return Intrinsics.areEqual(recordLoadingMap.get(dressKey), Boolean.TRUE);
    }

    public final void k(String dressKey, a listener) {
        Intrinsics.checkNotNullParameter(dressKey, "dressKey");
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (TextUtils.isEmpty(dressKey)) {
            return;
        }
        HashMap<String, ArrayList<WeakReference<a>>> hashMap = recordListenerMap;
        ArrayList<WeakReference<a>> arrayList = hashMap.get(dressKey);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            hashMap.put(dressKey, arrayList);
        }
        WeakReference<a> weakReference = new WeakReference<>(listener);
        if (arrayList.contains(weakReference)) {
            return;
        }
        arrayList.add(weakReference);
    }

    public final void o(a listener) {
        Set set;
        Intrinsics.checkNotNullParameter(listener, "listener");
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, ArrayList<WeakReference<a>>> entry : recordListenerMap.entrySet()) {
            ArrayList<WeakReference<a>> value = entry.getValue();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : value) {
                a aVar = (a) ((WeakReference) obj).get();
                if (aVar == null || Intrinsics.areEqual(aVar, listener)) {
                    arrayList2.add(obj);
                }
            }
            if (true ^ arrayList2.isEmpty()) {
                ArrayList<WeakReference<a>> value2 = entry.getValue();
                set = CollectionsKt___CollectionsKt.toSet(arrayList2);
                value2.removeAll(set);
            }
            if (entry.getValue().isEmpty()) {
                arrayList.add(entry.getKey());
            }
        }
        if (!arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                recordListenerMap.remove((String) it.next());
            }
        }
    }

    private final int m(Integer originalValue, int defaultValue) {
        return (originalValue == null || originalValue.intValue() <= 0) ? defaultValue : originalValue.intValue();
    }

    private final SingleRecordRequestParams h(final PortalStoreDressUpRecordParamConfig recordConfig, AvatarCharacterInfo avatarCharacterInfo) {
        int portraitId = recordConfig.getPortraitId();
        int m3 = m(Integer.valueOf(recordConfig.getWidth()), 270);
        int m16 = m(Integer.valueOf(recordConfig.getHeight()), 450);
        String b16 = com.tencent.sqshow.zootopia.utils.w.f373306a.b();
        MODE mode = (MODE) l(new Function0<MODE>() { // from class: com.tencent.sqshow.zootopia.nativeui.adapter.holder.DressUpItemRecordHelper$getRecordParam$finalRecordParam$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MODE invoke() {
                return MODE.valueOf(PortalStoreDressUpRecordParamConfig.this.getMode());
            }
        }, recordConfig.getMode(), MODE.FRAME);
        AppTheme appTheme = (AppTheme) l(new Function0<AppTheme>() { // from class: com.tencent.sqshow.zootopia.nativeui.adapter.holder.DressUpItemRecordHelper$getRecordParam$finalRecordParam$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AppTheme invoke() {
                return AppTheme.valueOf(PortalStoreDressUpRecordParamConfig.this.getTheme());
            }
        }, recordConfig.getTheme(), AppTheme.DAY);
        BusinessConfig businessConfig = new BusinessConfig(recordConfig.getBackgroundColor(), false, false, false, (BusinessConfig.FrameType) l(new Function0<BusinessConfig.FrameType>() { // from class: com.tencent.sqshow.zootopia.nativeui.adapter.holder.DressUpItemRecordHelper$getRecordParam$finalRecordParam$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BusinessConfig.FrameType invoke() {
                return BusinessConfig.FrameType.valueOf(PortalStoreDressUpRecordParamConfig.this.getFrameType());
            }
        }, recordConfig.getFrameType(), BusinessConfig.FrameType.PNG), 0, null, null, null, null, null, null, null, false, null, 0, null, 131054, null);
        businessConfig.G(new EngineType.Filament(FilamentNativeAppRecorder.class));
        SingleRecordRequestParams singleRecordRequestParams = new SingleRecordRequestParams(portraitId, b16, null, m3, m16, mode, businessConfig, 105, appTheme, Priority.HIGH, null, null, 0, false, null, null, 60420, null);
        singleRecordRequestParams.getUploadConfig().setNeedUpload(true);
        singleRecordRequestParams.getUploadConfig().setTarget(UploadConfig.UploadTarget.CDN_AVATAR);
        singleRecordRequestParams.getUploadConfig().setCheckAppearanceKey(false);
        singleRecordRequestParams.x(avatarCharacterInfo);
        return singleRecordRequestParams;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0101 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean n(uv4.ag outfitConfig, int originalPosInList) {
        gx4.a c16;
        uv4.al alVar;
        QLog.i("DressUpItemViewHolder_DressUpItemRecordHelper", 1, "startAvatarTemplateRecord_" + originalPosInList + ", hash= " + (outfitConfig != null ? outfitConfig.f440131b : null) + ", id= " + (outfitConfig != null ? Integer.valueOf(outfitConfig.f440130a) : null) + ", dressKey= " + ((outfitConfig == null || (alVar = outfitConfig.f440133d) == null) ? null : alVar.f440155d));
        if (outfitConfig == null) {
            return false;
        }
        uv4.al alVar2 = outfitConfig.f440133d;
        if ((alVar2 != null ? alVar2.f440152a : null) != null) {
            try {
                c16 = gx4.a.c(MessageNano.toByteArray(alVar2.f440152a));
            } catch (Exception unused) {
                QLog.e("DressUpItemViewHolder_DressUpItemRecordHelper", 1, "convert AvatarCharacter error - " + outfitConfig);
            }
            if (c16 != null) {
                return false;
            }
            uv4.al alVar3 = outfitConfig.f440133d;
            String str = alVar3 != null ? alVar3.f440155d : null;
            if (str == null) {
                str = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str, "outfitConfig.avatar?.dressKey ?: \"\"");
            }
            SingleRecordRequestParams h16 = f370779a.h(ZPlanQQMC.INSTANCE.getPortalStoreDressUpRecordParamConfig(), new AvatarCharacterInfo(c16, str));
            long currentTimeMillis = System.currentTimeMillis();
            String str2 = outfitConfig.f440133d.f440155d + " --" + System.currentTimeMillis();
            QLog.i("DressUpItemViewHolder_DressUpItemRecordHelper", 1, str2 + " AvatarTemplateRecord# BEGIN");
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new DressUpItemRecordHelper$startAvatarTemplateRecord$1$1(str2, h16, currentTimeMillis, str, null), 3, null);
            recordLoadingMap.put(str, Boolean.TRUE);
            return true;
        }
        c16 = null;
        if (c16 != null) {
        }
    }
}
