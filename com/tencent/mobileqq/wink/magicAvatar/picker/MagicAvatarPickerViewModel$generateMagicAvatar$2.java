package com.tencent.mobileqq.wink.magicAvatar.picker;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.wink.magicAvatar.model.MagicAvatarDataSource;
import com.tencent.mobileqq.wink.magicAvatar.model.MagicAvatarGenerateInfo;
import com.tencent.mobileqq.wink.magicAvatar.model.MagicAvatarMaterialInfo;
import com.tencent.mobileqq.wink.magicAvatar.model.MagicAvatarPicAndStyles;
import com.tencent.mobileqq.wink.magicAvatar.picker.MagicAvatarPickerViewModel;
import com.tencent.mobileqq.wink.magicstudio.MagicStudioDataSource;
import com.tencent.mobileqq.wink.utils.al;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableSharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.magicAvatar.picker.MagicAvatarPickerViewModel$generateMagicAvatar$2", f = "MagicAvatarPickerViewModel.kt", i = {0, 0, 1, 1, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5}, l = {75, 76, 93, 106, 109, 120}, m = "invokeSuspend", n = {"recordTime", "startTime", "recordTime", "startTime", "recordTime", "uploadUrl", "startTime", "recordTime", "uploadUrl", "info", MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_FIRST, "recordTime", "uploadUrl", "info", MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_FIRST, "startTime", "recordTime", "uploadUrl", "info", MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_FIRST, "avatar", "avatarQr", "startTime"}, s = {"L$0", "J$0", "L$0", "J$0", "L$0", "L$1", "J$0", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "J$0"})
/* loaded from: classes21.dex */
public final class MagicAvatarPickerViewModel$generateMagicAvatar$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $path;
    final /* synthetic */ String $styleID;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    final /* synthetic */ MagicAvatarPickerViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MagicAvatarPickerViewModel$generateMagicAvatar$2(MagicAvatarPickerViewModel magicAvatarPickerViewModel, String str, String str2, Continuation<? super MagicAvatarPickerViewModel$generateMagicAvatar$2> continuation) {
        super(2, continuation);
        this.this$0 = magicAvatarPickerViewModel;
        this.$path = str;
        this.$styleID = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MagicAvatarPickerViewModel$generateMagicAvatar$2(this.this$0, this.$path, this.$styleID, continuation);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0011. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0276 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0206 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0197 A[Catch: Exception -> 0x0087, TryCatch #1 {Exception -> 0x0087, blocks: (B:8:0x0037, B:10:0x027f, B:14:0x0051, B:16:0x020b, B:21:0x006d, B:23:0x01de, B:28:0x0080, B:30:0x016b, B:32:0x0197, B:34:0x01a0, B:36:0x01b9, B:51:0x014d), top: B:2:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01a0 A[Catch: Exception -> 0x0087, TryCatch #1 {Exception -> 0x0087, blocks: (B:8:0x0037, B:10:0x027f, B:14:0x0051, B:16:0x020b, B:21:0x006d, B:23:0x01de, B:28:0x0080, B:30:0x016b, B:32:0x0197, B:34:0x01a0, B:36:0x01b9, B:51:0x014d), top: B:2:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01b9 A[Catch: Exception -> 0x0087, TryCatch #1 {Exception -> 0x0087, blocks: (B:8:0x0037, B:10:0x027f, B:14:0x0051, B:16:0x020b, B:21:0x006d, B:23:0x01de, B:28:0x0080, B:30:0x016b, B:32:0x0197, B:34:0x01a0, B:36:0x01b9, B:51:0x014d), top: B:2:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0118 A[Catch: Exception -> 0x030d, TryCatch #0 {Exception -> 0x030d, blocks: (B:41:0x0090, B:43:0x010a, B:47:0x0118, B:49:0x0131, B:50:0x013e, B:57:0x009e, B:60:0x00ee, B:63:0x00f4, B:69:0x00b3, B:71:0x00c1, B:75:0x00d6), top: B:2:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0131 A[Catch: Exception -> 0x030d, TryCatch #0 {Exception -> 0x030d, blocks: (B:41:0x0090, B:43:0x010a, B:47:0x0118, B:49:0x0131, B:50:0x013e, B:57:0x009e, B:60:0x00ee, B:63:0x00f4, B:69:0x00b3, B:71:0x00c1, B:75:0x00d6), top: B:2:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0164 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0108 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00f3  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        MutableLiveData mutableLiveData;
        MutableLiveData mutableLiveData2;
        HashMap W1;
        long currentTimeMillis;
        HashMap hashMap;
        Object withContext;
        HashMap hashMap2;
        long j3;
        String str;
        Object b16;
        HashMap hashMap3;
        Object w3;
        HashMap hashMap4;
        String str2;
        long j16;
        boolean z16;
        HashMap hashMap5;
        MutableLiveData mutableLiveData3;
        ArrayList<MagicAvatarMaterialInfo> materials;
        MutableSharedFlow mutableSharedFlow;
        String str3;
        HashMap hashMap6;
        MagicAvatarPicAndStyles magicAvatarPicAndStyles;
        MutableLiveData mutableLiveData4;
        Object orNull;
        long currentTimeMillis2;
        Object o16;
        HashMap hashMap7;
        String str4;
        MagicAvatarPicAndStyles magicAvatarPicAndStyles2;
        MagicAvatarMaterialInfo magicAvatarMaterialInfo;
        long currentTimeMillis3;
        Object s16;
        MagicAvatarMaterialInfo magicAvatarMaterialInfo2;
        MagicAvatarPicAndStyles magicAvatarPicAndStyles3;
        String str5;
        HashMap hashMap8;
        String str6;
        String str7;
        MutableLiveData mutableLiveData5;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        MagicAvatarMaterialInfo magicAvatarMaterialInfo3 = null;
        String str8 = "";
        try {
            try {
            } catch (Exception e16) {
                mutableLiveData = this.this$0._selectEvent;
                mutableLiveData.postValue(new MagicAvatarPickerViewModel.b.a(e16));
            }
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    W1 = this.this$0.W1();
                    currentTimeMillis = System.currentTimeMillis();
                    hashMap = this.this$0.uploadUrlMap;
                    if (hashMap.containsKey(this.$path)) {
                        hashMap2 = this.this$0.uploadUrlMap;
                        String str9 = (String) hashMap2.get(this.$path);
                        if (str9 != null) {
                            str8 = str9;
                        }
                        W1.put("xsj_magic_avatar_upload_file", String.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        long currentTimeMillis4 = System.currentTimeMillis();
                        MagicAvatarDataSource magicAvatarDataSource = MagicAvatarDataSource.f323499a;
                        String str10 = this.$styleID;
                        this.L$0 = W1;
                        this.L$1 = str8;
                        this.J$0 = currentTimeMillis4;
                        this.label = 3;
                        w3 = magicAvatarDataSource.w(str8, str10, this);
                        if (w3 != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        hashMap4 = W1;
                        str2 = str8;
                        j16 = currentTimeMillis4;
                        MagicAvatarPicAndStyles magicAvatarPicAndStyles4 = (MagicAvatarPicAndStyles) w3;
                        hashMap4.put("xsj_magic_avatar_get_ids", String.valueOf(System.currentTimeMillis() - j16));
                        w53.b.f("MagicAvatarPickerViewModel", "requestStyleFirstTime = " + magicAvatarPicAndStyles4);
                        materials = magicAvatarPicAndStyles4.getMaterials();
                        if (materials != null) {
                            orNull = CollectionsKt___CollectionsKt.getOrNull(materials, 0);
                            magicAvatarMaterialInfo3 = (MagicAvatarMaterialInfo) orNull;
                        }
                        if (magicAvatarMaterialInfo3 != null) {
                            mutableLiveData4 = this.this$0._selectEvent;
                            mutableLiveData4.postValue(new MagicAvatarPickerViewModel.b.a(new Exception("no styles")));
                            return Unit.INSTANCE;
                        }
                        magicAvatarMaterialInfo3.setSelected(true);
                        mutableSharedFlow = this.this$0._styleList;
                        ArrayList<MagicAvatarMaterialInfo> materials2 = magicAvatarPicAndStyles4.getMaterials();
                        Intrinsics.checkNotNull(materials2);
                        this.L$0 = hashMap4;
                        this.L$1 = str2;
                        this.L$2 = magicAvatarPicAndStyles4;
                        this.L$3 = magicAvatarMaterialInfo3;
                        this.label = 4;
                        if (mutableSharedFlow.emit(materials2, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        str3 = str2;
                        hashMap6 = hashMap4;
                        magicAvatarPicAndStyles = magicAvatarPicAndStyles4;
                        currentTimeMillis2 = System.currentTimeMillis();
                        MagicAvatarDataSource magicAvatarDataSource2 = MagicAvatarDataSource.f323499a;
                        String styleName = magicAvatarMaterialInfo3.getStyleName();
                        String materialUrl = magicAvatarMaterialInfo3.getMaterialUrl();
                        String materialId = magicAvatarMaterialInfo3.getMaterialId();
                        this.L$0 = hashMap6;
                        this.L$1 = str3;
                        this.L$2 = magicAvatarPicAndStyles;
                        this.L$3 = magicAvatarMaterialInfo3;
                        this.J$0 = currentTimeMillis2;
                        this.label = 5;
                        o16 = magicAvatarDataSource2.o(str3, styleName, materialUrl, materialId, this);
                        if (o16 != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        hashMap7 = hashMap6;
                        str4 = str3;
                        magicAvatarPicAndStyles2 = magicAvatarPicAndStyles;
                        magicAvatarMaterialInfo = magicAvatarMaterialInfo3;
                        Pair pair = (Pair) o16;
                        String str11 = (String) pair.component1();
                        String str12 = (String) pair.component2();
                        hashMap7.put("xsj_magic_avatar_generate_time", String.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                        w53.b.f("MagicAvatarPickerViewModel", "makeAvatar = " + str11 + ", " + str12);
                        currentTimeMillis3 = System.currentTimeMillis();
                        MagicStudioDataSource magicStudioDataSource = MagicStudioDataSource.f323652a;
                        this.L$0 = hashMap7;
                        this.L$1 = str4;
                        this.L$2 = magicAvatarPicAndStyles2;
                        this.L$3 = magicAvatarMaterialInfo;
                        this.L$4 = str11;
                        this.L$5 = str12;
                        this.J$0 = currentTimeMillis3;
                        this.label = 6;
                        s16 = MagicStudioDataSource.s(magicStudioDataSource, str11, false, null, this, 6, null);
                        if (s16 != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        magicAvatarMaterialInfo2 = magicAvatarMaterialInfo;
                        magicAvatarPicAndStyles3 = magicAvatarPicAndStyles2;
                        str5 = str4;
                        hashMap8 = hashMap7;
                        str6 = str11;
                        str7 = str12;
                        String str13 = (String) s16;
                        hashMap8.put("xsj_magic_avatar_download_time", String.valueOf(System.currentTimeMillis() - currentTimeMillis3));
                        w53.b.f("MagicAvatarPickerViewModel", "checkAndDownloadImg = " + str13);
                        magicAvatarMaterialInfo2.setGenerateQRUrl(str7);
                        magicAvatarMaterialInfo2.setGenerateUrl(str6);
                        magicAvatarMaterialInfo2.setLocalPicPath(str13);
                        MagicAvatarGenerateInfo magicAvatarGenerateInfo = new MagicAvatarGenerateInfo();
                        String str14 = this.$styleID;
                        magicAvatarGenerateInfo.setUploadUrl(str5);
                        magicAvatarGenerateInfo.setGenerateAvatarUrl(str6);
                        magicAvatarGenerateInfo.setGenerateAvatarFilePath(str13);
                        magicAvatarGenerateInfo.setGenerateAvatarQrUrl(str7);
                        magicAvatarGenerateInfo.setGender(magicAvatarPicAndStyles3.getGender());
                        magicAvatarGenerateInfo.setGlass(magicAvatarPicAndStyles3.getGlass());
                        magicAvatarGenerateInfo.setMaterials(magicAvatarPicAndStyles3.getMaterials());
                        magicAvatarGenerateInfo.setOriginStyleName(str14);
                        hashMap8.put("xsj_magic_avatar_generate_whole_time", String.valueOf(System.currentTimeMillis() - currentTimeMillis3));
                        this.this$0.X1(hashMap8);
                        mutableLiveData5 = this.this$0._selectEvent;
                        mutableLiveData5.postValue(new MagicAvatarPickerViewModel.b.C9056b(magicAvatarGenerateInfo));
                        return Unit.INSTANCE;
                    }
                    CoroutineDispatcher io5 = Dispatchers.getIO();
                    MagicAvatarPickerViewModel$generateMagicAvatar$2$compressPath$1 magicAvatarPickerViewModel$generateMagicAvatar$2$compressPath$1 = new MagicAvatarPickerViewModel$generateMagicAvatar$2$compressPath$1(this.$path, null);
                    this.L$0 = W1;
                    this.J$0 = currentTimeMillis;
                    this.label = 1;
                    withContext = BuildersKt.withContext(io5, magicAvatarPickerViewModel$generateMagicAvatar$2$compressPath$1, this);
                    if (withContext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    HashMap hashMap9 = W1;
                    j3 = currentTimeMillis;
                    str = (String) withContext;
                    if (str == null) {
                        str8 = str;
                    }
                    al alVar = al.f326675a;
                    this.L$0 = hashMap9;
                    this.J$0 = j3;
                    this.label = 2;
                    b16 = al.b(alVar, str8, false, this, 2, null);
                    if (b16 != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    hashMap3 = hashMap9;
                    str8 = (String) b16;
                    if (str8.length() != 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16) {
                        mutableLiveData3 = this.this$0._selectEvent;
                        mutableLiveData3.postValue(new MagicAvatarPickerViewModel.b.d(new IllegalStateException("upload fail")));
                        return Unit.INSTANCE;
                    }
                    hashMap5 = this.this$0.uploadUrlMap;
                    hashMap5.put(this.$path, str8);
                    W1 = hashMap3;
                    currentTimeMillis = j3;
                    W1.put("xsj_magic_avatar_upload_file", String.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    long currentTimeMillis42 = System.currentTimeMillis();
                    MagicAvatarDataSource magicAvatarDataSource3 = MagicAvatarDataSource.f323499a;
                    String str102 = this.$styleID;
                    this.L$0 = W1;
                    this.L$1 = str8;
                    this.J$0 = currentTimeMillis42;
                    this.label = 3;
                    w3 = magicAvatarDataSource3.w(str8, str102, this);
                    if (w3 != coroutine_suspended) {
                    }
                case 1:
                    currentTimeMillis = this.J$0;
                    W1 = (HashMap) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    withContext = obj;
                    HashMap hashMap92 = W1;
                    j3 = currentTimeMillis;
                    str = (String) withContext;
                    if (str == null) {
                    }
                    al alVar2 = al.f326675a;
                    this.L$0 = hashMap92;
                    this.J$0 = j3;
                    this.label = 2;
                    b16 = al.b(alVar2, str8, false, this, 2, null);
                    if (b16 != coroutine_suspended) {
                    }
                    break;
                case 2:
                    long j17 = this.J$0;
                    hashMap3 = (HashMap) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    j3 = j17;
                    b16 = obj;
                    str8 = (String) b16;
                    if (str8.length() != 0) {
                    }
                    if (!z16) {
                    }
                    break;
                case 3:
                    j16 = this.J$0;
                    str2 = (String) this.L$1;
                    hashMap4 = (HashMap) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    w3 = obj;
                    MagicAvatarPicAndStyles magicAvatarPicAndStyles42 = (MagicAvatarPicAndStyles) w3;
                    hashMap4.put("xsj_magic_avatar_get_ids", String.valueOf(System.currentTimeMillis() - j16));
                    w53.b.f("MagicAvatarPickerViewModel", "requestStyleFirstTime = " + magicAvatarPicAndStyles42);
                    materials = magicAvatarPicAndStyles42.getMaterials();
                    if (materials != null) {
                    }
                    if (magicAvatarMaterialInfo3 != null) {
                    }
                    break;
                case 4:
                    MagicAvatarMaterialInfo magicAvatarMaterialInfo4 = (MagicAvatarMaterialInfo) this.L$3;
                    MagicAvatarPicAndStyles magicAvatarPicAndStyles5 = (MagicAvatarPicAndStyles) this.L$2;
                    String str15 = (String) this.L$1;
                    HashMap hashMap10 = (HashMap) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    magicAvatarMaterialInfo3 = magicAvatarMaterialInfo4;
                    magicAvatarPicAndStyles = magicAvatarPicAndStyles5;
                    str3 = str15;
                    hashMap6 = hashMap10;
                    currentTimeMillis2 = System.currentTimeMillis();
                    MagicAvatarDataSource magicAvatarDataSource22 = MagicAvatarDataSource.f323499a;
                    String styleName2 = magicAvatarMaterialInfo3.getStyleName();
                    String materialUrl2 = magicAvatarMaterialInfo3.getMaterialUrl();
                    String materialId2 = magicAvatarMaterialInfo3.getMaterialId();
                    this.L$0 = hashMap6;
                    this.L$1 = str3;
                    this.L$2 = magicAvatarPicAndStyles;
                    this.L$3 = magicAvatarMaterialInfo3;
                    this.J$0 = currentTimeMillis2;
                    this.label = 5;
                    o16 = magicAvatarDataSource22.o(str3, styleName2, materialUrl2, materialId2, this);
                    if (o16 != coroutine_suspended) {
                    }
                    break;
                case 5:
                    long j18 = this.J$0;
                    MagicAvatarMaterialInfo magicAvatarMaterialInfo5 = (MagicAvatarMaterialInfo) this.L$3;
                    MagicAvatarPicAndStyles magicAvatarPicAndStyles6 = (MagicAvatarPicAndStyles) this.L$2;
                    String str16 = (String) this.L$1;
                    HashMap hashMap11 = (HashMap) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    currentTimeMillis2 = j18;
                    magicAvatarMaterialInfo = magicAvatarMaterialInfo5;
                    magicAvatarPicAndStyles2 = magicAvatarPicAndStyles6;
                    str4 = str16;
                    hashMap7 = hashMap11;
                    o16 = obj;
                    Pair pair2 = (Pair) o16;
                    String str112 = (String) pair2.component1();
                    String str122 = (String) pair2.component2();
                    hashMap7.put("xsj_magic_avatar_generate_time", String.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                    w53.b.f("MagicAvatarPickerViewModel", "makeAvatar = " + str112 + ", " + str122);
                    currentTimeMillis3 = System.currentTimeMillis();
                    MagicStudioDataSource magicStudioDataSource2 = MagicStudioDataSource.f323652a;
                    this.L$0 = hashMap7;
                    this.L$1 = str4;
                    this.L$2 = magicAvatarPicAndStyles2;
                    this.L$3 = magicAvatarMaterialInfo;
                    this.L$4 = str112;
                    this.L$5 = str122;
                    this.J$0 = currentTimeMillis3;
                    this.label = 6;
                    s16 = MagicStudioDataSource.s(magicStudioDataSource2, str112, false, null, this, 6, null);
                    if (s16 != coroutine_suspended) {
                    }
                    break;
                case 6:
                    long j19 = this.J$0;
                    str7 = (String) this.L$5;
                    str6 = (String) this.L$4;
                    magicAvatarMaterialInfo2 = (MagicAvatarMaterialInfo) this.L$3;
                    magicAvatarPicAndStyles3 = (MagicAvatarPicAndStyles) this.L$2;
                    str5 = (String) this.L$1;
                    hashMap8 = (HashMap) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    currentTimeMillis3 = j19;
                    s16 = obj;
                    String str132 = (String) s16;
                    hashMap8.put("xsj_magic_avatar_download_time", String.valueOf(System.currentTimeMillis() - currentTimeMillis3));
                    w53.b.f("MagicAvatarPickerViewModel", "checkAndDownloadImg = " + str132);
                    magicAvatarMaterialInfo2.setGenerateQRUrl(str7);
                    magicAvatarMaterialInfo2.setGenerateUrl(str6);
                    magicAvatarMaterialInfo2.setLocalPicPath(str132);
                    MagicAvatarGenerateInfo magicAvatarGenerateInfo2 = new MagicAvatarGenerateInfo();
                    String str142 = this.$styleID;
                    magicAvatarGenerateInfo2.setUploadUrl(str5);
                    magicAvatarGenerateInfo2.setGenerateAvatarUrl(str6);
                    magicAvatarGenerateInfo2.setGenerateAvatarFilePath(str132);
                    magicAvatarGenerateInfo2.setGenerateAvatarQrUrl(str7);
                    magicAvatarGenerateInfo2.setGender(magicAvatarPicAndStyles3.getGender());
                    magicAvatarGenerateInfo2.setGlass(magicAvatarPicAndStyles3.getGlass());
                    magicAvatarGenerateInfo2.setMaterials(magicAvatarPicAndStyles3.getMaterials());
                    magicAvatarGenerateInfo2.setOriginStyleName(str142);
                    hashMap8.put("xsj_magic_avatar_generate_whole_time", String.valueOf(System.currentTimeMillis() - currentTimeMillis3));
                    this.this$0.X1(hashMap8);
                    mutableLiveData5 = this.this$0._selectEvent;
                    mutableLiveData5.postValue(new MagicAvatarPickerViewModel.b.C9056b(magicAvatarGenerateInfo2));
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Exception e17) {
            mutableLiveData2 = this.this$0._selectEvent;
            mutableLiveData2.postValue(new MagicAvatarPickerViewModel.b.d(e17));
            return Unit.INSTANCE;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MagicAvatarPickerViewModel$generateMagicAvatar$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
