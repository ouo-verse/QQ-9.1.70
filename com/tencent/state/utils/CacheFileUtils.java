package com.tencent.state.utils;

import com.google.protobuf.nano.MessageNano;
import com.tencent.qqmini.sdk.request.GetAdInfoRequest;
import com.tencent.state.api.INetworkDelegate;
import com.tencent.state.api.INetworkDelegateCallBack;
import com.tencent.state.api.SquareErrorData;
import com.tencent.state.config.NetworkConfig;
import com.tencent.state.service.VasStatusSquareService;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareFragment;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.api.SquareBaseMessageRecord;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.data.ResourceIdentify;
import com.tencent.state.square.data.SquareAvatarItem;
import hs4.f;
import hs4.m;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt__FileReadWriteKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import xt4.ag;
import xt4.o;
import xt4.p;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\rJ\"\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\r0\u0012J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0018\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u0013J=\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00042\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u0016\u00a2\u0006\u0002\u0010!J\u0016\u0010\"\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010#\u001a\u00020$J;\u0010%\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00042\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u0016H\u0002\u00a2\u0006\u0002\u0010!R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u00a8\u0006'"}, d2 = {"Lcom/tencent/state/utils/CacheFileUtils;", "", "()V", "CACHE_PATH", "", "DIR_NAME", "TAG", "needUpdateIndex", "", "uin", "getUin", "()Ljava/lang/String;", "doUpdateWhenExit", "", "getCache", "name", "Lcom/tencent/state/utils/CachePath;", "cb", "Lkotlin/Function1;", "", "getChatLandCacheType", "appId", "", "getFileUrl", "saveCache", "data", "updateIndexCacheIfNeed", GetAdInfoRequest.SOURCE_FROM, "unreadMsgList", "", "Lcom/tencent/state/square/api/SquareBaseMessageRecord;", "recentUserList", "mapId", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;)V", "updateItemIfNeed", "mapItem", "Lcom/tencent/state/square/data/SquareAvatarItem;", "updateUserList", "unreadList", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class CacheFileUtils {
    private static final String TAG = "CacheFileUtils";
    private static boolean needUpdateIndex;
    public static final CacheFileUtils INSTANCE = new CacheFileUtils();
    private static final String DIR_NAME = "data_cache";
    private static final String CACHE_PATH = SquareBase.INSTANCE.getConfig().getRootCacheDir().getAbsolutePath() + File.separator + DIR_NAME;

    CacheFileUtils() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getFileUrl(CachePath name) {
        return CACHE_PATH + '/' + name.getUrl() + '-' + getUin() + ".text";
    }

    private final String getUin() {
        return SquareBase.INSTANCE.getConfig().getCommonUtils().getCurrentAccountUin();
    }

    public final void getCache(final CachePath name, final Function1<? super byte[], Unit> cb5) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        SquareBaseKt.getSquareThread().postOnFileThread(new Function0<Unit>() { // from class: com.tencent.state.utils.CacheFileUtils$getCache$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                String fileUrl;
                final byte[] readBytes;
                fileUrl = CacheFileUtils.INSTANCE.getFileUrl(CachePath.this);
                File file = new File(fileUrl);
                if (file.exists()) {
                    try {
                        readBytes = FilesKt__FileReadWriteKt.readBytes(file);
                        SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.utils.CacheFileUtils$getCache$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                cb5.invoke(readBytes);
                                SquareBaseKt.getSquareLog().i("CacheFileUtils", "getCache success: name: " + CachePath.this.getUrl());
                            }
                        });
                    } catch (IOException e16) {
                        SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "CacheFileUtils", "getCache fail: " + e16 + ", name: " + CachePath.this.getUrl(), null, 4, null);
                    }
                }
            }
        });
    }

    public final CachePath getChatLandCacheType(int appId) {
        if (!SquareSwitchUtils.INSTANCE.enableChatLandUseCache()) {
            return null;
        }
        if (appId == 1004) {
            return CachePath.ChatLandEnterRoom1;
        }
        if (appId != 1005) {
            return null;
        }
        return CachePath.ChatLandEnterRoom2;
    }

    public final void saveCache(final CachePath name, final byte[] data) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (data != null) {
            SquareBaseKt.getSquareThread().postOnFileThread(new Function0<Unit>() { // from class: com.tencent.state.utils.CacheFileUtils$saveCache$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    String str;
                    String fileUrl;
                    CacheFileUtils cacheFileUtils = CacheFileUtils.INSTANCE;
                    str = CacheFileUtils.CACHE_PATH;
                    File file = new File(str);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    fileUrl = cacheFileUtils.getFileUrl(CachePath.this);
                    File file2 = new File(fileUrl);
                    try {
                        if (file2.exists()) {
                            file2.delete();
                        }
                        FileOutputStream fileOutputStream = new FileOutputStream(file2);
                        try {
                            fileOutputStream.write(data);
                            Unit unit = Unit.INSTANCE;
                            CloseableKt.closeFinally(fileOutputStream, null);
                            SquareBaseKt.getSquareLog().i("CacheFileUtils", "saveCache success: name: " + CachePath.this.getUrl());
                        } finally {
                        }
                    } catch (IOException e16) {
                        SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "CacheFileUtils", "saveCache fail: " + e16 + ", name: " + CachePath.this.getUrl(), null, 4, null);
                    }
                }
            });
        }
    }

    public final void updateIndexCacheIfNeed(final String sourceFrom, final List<? extends SquareBaseMessageRecord> unreadMsgList, final List<String> recentUserList, final Integer mapId) {
        Intrinsics.checkNotNullParameter(sourceFrom, "sourceFrom");
        if (needUpdateIndex) {
            needUpdateIndex = false;
            try {
                SquareBaseKt.getSquareThread().postOnSubThread(new Function0<Unit>() { // from class: com.tencent.state.utils.CacheFileUtils$updateIndexCacheIfNeed$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        List list = unreadMsgList;
                        if (list != null) {
                            CacheFileUtils cacheFileUtils = CacheFileUtils.INSTANCE;
                            String str = sourceFrom;
                            List list2 = recentUserList;
                            if (list2 == null) {
                                list2 = CollectionsKt__CollectionsKt.emptyList();
                            }
                            cacheFileUtils.updateUserList(str, list, list2, mapId);
                            SquareBaseKt.getSquareLog().i("CacheFileUtils", "updateIndexCacheIfNeed save file");
                        }
                    }
                });
            } catch (Throwable th5) {
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "updateIndexCacheIfNeed fail: " + th5, null, 4, null);
            }
        }
    }

    public final void updateItemIfNeed(final CachePath name, final SquareAvatarItem mapItem) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(mapItem, "mapItem");
        getCache(name, new Function1<byte[], Unit>() { // from class: com.tencent.state.utils.CacheFileUtils$updateItemIfNeed$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(byte[] bArr) {
                invoke2(bArr);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(byte[] it) {
                String str;
                ag agVar;
                ResourceIdentify dynamic;
                ResourceIdentify dynamic2;
                Intrinsics.checkNotNullParameter(it, "it");
                try {
                    p c16 = p.c(it);
                    ag[] agVarArr = c16.f448613a;
                    Intrinsics.checkNotNullExpressionValue(agVarArr, "rsp.infos");
                    int length = agVarArr.length;
                    int i3 = 0;
                    while (true) {
                        str = null;
                        if (i3 >= length) {
                            agVar = null;
                            break;
                        }
                        agVar = agVarArr[i3];
                        if (Intrinsics.areEqual(String.valueOf(agVar.f448537a), SquareAvatarItem.this.getUin())) {
                            break;
                        } else {
                            i3++;
                        }
                    }
                    if (agVar != null) {
                        agVar.f448544h = SquareAvatarItem.this.getDressKey();
                        m mVar = agVar.f448542f.f406193c.f406172a;
                        Resource userResource = SquareAvatarItem.this.getUserResource();
                        mVar.f406169a = (userResource == null || (dynamic2 = userResource.getDynamic()) == null) ? null : dynamic2.getUrl();
                        m mVar2 = agVar.f448542f.f406193c.f406172a;
                        Resource userResource2 = SquareAvatarItem.this.getUserResource();
                        if (userResource2 != null && (dynamic = userResource2.getDynamic()) != null) {
                            str = dynamic.getMd5();
                        }
                        mVar2.f406170b = str;
                        try {
                            CacheFileUtils.INSTANCE.saveCache(name, MessageNano.toByteArray(c16));
                        } catch (Throwable th5) {
                            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "CacheFileUtils", "updateCacheIfNeed saveCache fail: " + th5, null, 4, null);
                        }
                    }
                } catch (Throwable th6) {
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "CacheFileUtils", "updateCacheIfNeed parseFrom fail: " + th6, null, 4, null);
                }
            }
        });
    }

    public final void doUpdateWhenExit() {
        needUpdateIndex = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateUserList(final String sourceFrom, List<? extends SquareBaseMessageRecord> unreadList, List<String> recentUserList, Integer mapId) {
        int collectionSizeOrDefault;
        long[] longArray;
        int collectionSizeOrDefault2;
        long[] longArray2;
        Map<String, String> emptyMap;
        Long longOrNull;
        Long longOrNull2;
        SquareBaseKt.getSquareLog().i(TAG, "updateUserList, from:" + sourceFrom);
        o oVar = new o();
        oVar.f448612g = SquareFragment.INSTANCE.getChatLandAppId();
        List<? extends SquareBaseMessageRecord> list = unreadList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (true) {
            long j3 = 0;
            if (!it.hasNext()) {
                break;
            }
            longOrNull2 = StringsKt__StringNumberConversionsKt.toLongOrNull(((SquareBaseMessageRecord) it.next()).getUin());
            if (longOrNull2 != null) {
                j3 = longOrNull2.longValue();
            }
            arrayList.add(Long.valueOf(j3));
        }
        longArray = CollectionsKt___CollectionsKt.toLongArray(arrayList);
        oVar.f448606a = longArray;
        oVar.f448607b = 1;
        oVar.f448609d = mapId != null ? mapId.intValue() : 0;
        f fVar = new f();
        Square square = Square.INSTANCE;
        fVar.f406137a = square.getConfig().getCommonUtils().getGpuInfo();
        fVar.f406138b = square.getConfig().getCommonUtils().getDeviceName();
        fVar.f406139c = square.getConfig().getCommonUtils().getSystemVersion();
        Unit unit = Unit.INSTANCE;
        oVar.f448608c = fVar;
        List<String> list2 = recentUserList;
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
        Iterator<T> it5 = list2.iterator();
        while (it5.hasNext()) {
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull((String) it5.next());
            arrayList2.add(Long.valueOf(longOrNull != null ? longOrNull.longValue() : 0L));
        }
        longArray2 = CollectionsKt___CollectionsKt.toLongArray(arrayList2);
        oVar.f448610e = longArray2;
        oVar.f448611f = sourceFrom;
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate != null) {
            byte[] byteArray = MessageNano.toByteArray(oVar);
            Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
            emptyMap = MapsKt__MapsKt.emptyMap();
            networkDelegate.sendVasProxyRequest(VasStatusSquareService.CMD_SERVICE, VasStatusSquareService.METHOD_GET_USER_LIST, byteArray, emptyMap, new INetworkDelegateCallBack() { // from class: com.tencent.state.utils.CacheFileUtils$updateUserList$1
                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onError(SquareErrorData data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "CacheFileUtils", "updateUserList fail " + data.getErrCode() + ", " + data.getErrMsg(), null, 4, null);
                }

                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onReceive(byte[] rspData) {
                    if (SquareSwitchUtils.INSTANCE.enableIndexUseCache()) {
                        CacheFileUtils.INSTANCE.saveCache(CachePath.IndexUserList, rspData);
                        SquareBaseKt.getSquareLog().i("CacheFileUtils", "updateUserList data response, from:" + sourceFrom);
                    }
                }
            });
            return;
        }
        SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "updateUserList fail: NetworkConfig.getNetworkDelegate is null", null, 4, null);
    }
}
