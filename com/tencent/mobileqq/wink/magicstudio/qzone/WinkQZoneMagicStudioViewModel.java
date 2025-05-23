package com.tencent.mobileqq.wink.magicstudio.qzone;

import android.app.Activity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioButtonInfo;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioHistoryImageModel;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioPicStyle;
import com.tencent.mobileqq.wink.magicstudio.utils.WinkMagicStudioUtils;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qshadow.ShadowAIGCStatus$GetStatusReply;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 62\u00020\u0001:\u00017B\u0007\u00a2\u0006\u0004\b4\u00105J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u0004J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0006R\"\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R(\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR.\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u0017\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR*\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#0\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010\u0017\u001a\u0004\b%\u0010\u0019\"\u0004\b&\u0010\u001bR$\u0010+\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010\u000f\u001a\u0004\b)\u0010\u0011\"\u0004\b*\u0010\u0013R$\u00103\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/qzone/WinkQZoneMagicStudioViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "metaCategory", "", "Q1", "", "scene", "S1", "R1", "T1", "actionType", "L1", "", "i", "Ljava/lang/String;", "getShareFrom", "()Ljava/lang/String;", "X1", "(Ljava/lang/String;)V", "shareFrom", "Landroidx/lifecycle/MutableLiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "P1", "()Landroidx/lifecycle/MutableLiveData;", "setPic2picMataCategoryLiveData", "(Landroidx/lifecycle/MutableLiveData;)V", "pic2picMataCategoryLiveData", "", "Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioHistoryImageModel;", BdhLogUtil.LogTag.Tag_Conn, "O1", "setPic2picHistoryLiveData", "pic2picHistoryLiveData", "Lcom/tencent/mobileqq/wink/magicstudio/model/e;", "D", "N1", "setPic2picButtonInfoLiveData", "pic2picButtonInfoLiveData", "E", "getPic2picDefaultSelectedStyleId", "W1", "pic2picDefaultSelectedStyleId", "Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioPicStyle;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioPicStyle;", "M1", "()Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioPicStyle;", "U1", "(Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioPicStyle;)V", "currentSelectedMagicStudioPicStyle", "<init>", "()V", "G", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkQZoneMagicStudioViewModel extends ViewModel {

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private String pic2picDefaultSelectedStyleId;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private MagicStudioPicStyle currentSelectedMagicStudioPicStyle;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String shareFrom = "0";

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MutableLiveData<MetaCategory> pic2picMataCategoryLiveData = new MutableLiveData<>();

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<List<MagicStudioHistoryImageModel>> pic2picHistoryLiveData = new MutableLiveData<>();

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<MagicStudioButtonInfo> pic2picButtonInfoLiveData = new MutableLiveData<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/qzone/WinkQZoneMagicStudioViewModel$a;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/wink/magicstudio/qzone/WinkQZoneMagicStudioViewModel;", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.magicstudio.qzone.WinkQZoneMagicStudioViewModel$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Nullable
        public final WinkQZoneMagicStudioViewModel a(@Nullable Activity activity) {
            if (activity instanceof ViewModelStoreOwner) {
                return (WinkQZoneMagicStudioViewModel) new ViewModelProvider((ViewModelStoreOwner) activity).get(WinkQZoneMagicStudioViewModel.class);
            }
            return null;
        }

        Companion() {
        }
    }

    public final void L1(int actionType) {
        String str;
        if (actionType == 2) {
            m83.b bVar = m83.b.f416442a;
            MagicStudioPicStyle magicStudioPicStyle = this.currentSelectedMagicStudioPicStyle;
            if (magicStudioPicStyle != null) {
                str = magicStudioPicStyle.getStyleId();
            } else {
                str = null;
            }
            bVar.D(str, this.shareFrom, WinkDaTongReportConstant.PageId.PG_QZ_MAGIC_STUDIO_DETAIL);
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(WinkCoroutineScopes.f317652a.c()), null, null, new WinkQZoneMagicStudioViewModel$doAction$1(actionType, this, null), 3, null);
    }

    @Nullable
    /* renamed from: M1, reason: from getter */
    public final MagicStudioPicStyle getCurrentSelectedMagicStudioPicStyle() {
        return this.currentSelectedMagicStudioPicStyle;
    }

    @NotNull
    public final MutableLiveData<MagicStudioButtonInfo> N1() {
        return this.pic2picButtonInfoLiveData;
    }

    @NotNull
    public final MutableLiveData<List<MagicStudioHistoryImageModel>> O1() {
        return this.pic2picHistoryLiveData;
    }

    @NotNull
    public final MutableLiveData<MetaCategory> P1() {
        return this.pic2picMataCategoryLiveData;
    }

    public final void Q1(@Nullable MetaCategory metaCategory) {
        String str;
        String str2 = null;
        if (metaCategory != null) {
            str = metaCategory.f30532id;
        } else {
            str = null;
        }
        w53.b.a("WinkQZoneMagicStudioViewModel", "handlePic2PicMaterials metaCategory:" + str);
        if (metaCategory != null) {
            str2 = metaCategory.f30532id;
        }
        if (Intrinsics.areEqual("pic_gen_pic", str2)) {
            this.pic2picMataCategoryLiveData.postValue(metaCategory);
        }
    }

    public final void R1() {
        if (m83.a.f416440a.e()) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(WinkCoroutineScopes.f317652a.b()), null, null, new WinkQZoneMagicStudioViewModel$queryMagicStudioHistory$1(this, null), 3, null);
        } else {
            this.pic2picHistoryLiveData.postValue(new ArrayList());
        }
    }

    public final void S1(int scene) {
        WinkMagicStudioUtils.f323888a.o(scene, new Function1<ShadowAIGCStatus$GetStatusReply, Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.qzone.WinkQZoneMagicStudioViewModel$requestCgiGetStatus$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ShadowAIGCStatus$GetStatusReply shadowAIGCStatus$GetStatusReply) {
                invoke2(shadowAIGCStatus$GetStatusReply);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ShadowAIGCStatus$GetStatusReply it) {
                Intrinsics.checkNotNullParameter(it, "it");
                WinkQZoneMagicStudioViewModel.this.N1().postValue(MagicStudioButtonInfo.INSTANCE.a(it));
            }
        });
    }

    public final void T1() {
        L1(99);
    }

    public final void U1(@Nullable MagicStudioPicStyle magicStudioPicStyle) {
        this.currentSelectedMagicStudioPicStyle = magicStudioPicStyle;
    }

    public final void W1(@Nullable String str) {
        this.pic2picDefaultSelectedStyleId = str;
    }

    public final void X1(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.shareFrom = str;
    }
}
