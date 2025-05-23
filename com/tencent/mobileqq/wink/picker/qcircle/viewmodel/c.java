package com.tencent.mobileqq.wink.picker.qcircle.viewmodel;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.edit.manager.WinkDataServiceHandler;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.editor.MaterialType;
import com.tencent.mobileqq.wink.editor.music.WinkEditorMusicHelper;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import com.tencent.mobileqq.wink.picker.qcircle.viewmodel.c;
import com.tencent.mobileqq.wink.tag.TagRetriever;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleSmartMatchMusic$MusicInfoRsp;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 52\u00020\u0001:\u000267B\u0007\u00a2\u0006\u0004\b3\u00104J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J4\u0010\u0010\u001a\u00020\b2\"\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r`\u000e2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J.\u0010\u0016\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\r2\u0012\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u00122\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\"\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u0004H\u0002J\u0018\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J4\u0010\u001a\u001a\u00020\b2\"\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r`\u000e2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J4\u0010\u001b\u001a\u00020\b2\"\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r`\u000e2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001a\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u0004H\u0002J\u0012\u0010\u001e\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u001f\u001a\u00020\rH\u0016J\u000e\u0010 \u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\"\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010!\u001a\u00020\rR\u0016\u0010%\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R$\u0010*\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u00048\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b'\u0010$\u001a\u0004\b(\u0010)R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00060\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060.8\u0006\u00a2\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qcircle/viewmodel/c;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "Landroid/content/Intent;", "intent", "", "e2", "Lcom/tencent/mobileqq/wink/picker/qcircle/viewmodel/c$b;", "mediaBannerData", "", "Q1", "P1", "Z1", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "schemaData", "W1", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, "Landroidx/lifecycle/MutableLiveData;", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "materialLiveData", "T1", "forceUpdate", "b2", "S1", ICustomDataEditor.STRING_ARRAY_PARAM_2, "d2", "R1", "f2", "M1", "getLogTag", "U1", MiniAppGetGameTaskTicketServlet.KEY_TASKID, SemanticAttributes.DbSystemValues.H2, "i", "Z", "hasSetGuideData", "<set-?>", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "N1", "()Z", "hasBanner", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "_mediaBannerData", "Landroidx/lifecycle/LiveData;", "D", "Landroidx/lifecycle/LiveData;", "O1", "()Landroidx/lifecycle/LiveData;", "<init>", "()V", "E", "a", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class c extends BaseViewModel {

    /* renamed from: C */
    @NotNull
    private final MutableLiveData<MediaBannerData> _mediaBannerData;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final LiveData<MediaBannerData> mediaBannerData;

    /* renamed from: i, reason: from kotlin metadata */
    private boolean hasSetGuideData;

    /* renamed from: m */
    private boolean hasBanner;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0002\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\"\u0010#J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR$\u0010\u001a\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0010\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u001b\u0010\f\"\u0004\b\u001c\u0010\u000eR\"\u0010\u001f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\n\u001a\u0004\b\t\u0010\f\"\u0004\b\u001e\u0010\u000eR$\u0010!\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\n\u001a\u0004\b\u0015\u0010\f\"\u0004\b \u0010\u000e\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qcircle/viewmodel/c$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "j", "(Ljava/lang/String;)V", "mediaName", "b", "e", "k", "mediaType", "Landroid/graphics/drawable/Drawable;", "c", "Landroid/graphics/drawable/Drawable;", "()Landroid/graphics/drawable/Drawable;", h.F, "(Landroid/graphics/drawable/Drawable;)V", "mediaIcon", "f", "l", "userGuideOperationActivityId", "g", "extendDes", "i", "mediaIconUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Landroid/graphics/drawable/Drawable;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.picker.qcircle.viewmodel.c$b, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class MediaBannerData {

        /* renamed from: a, reason: from kotlin metadata and from toString */
        @Nullable
        private String mediaName;

        /* renamed from: b, reason: from kotlin metadata and from toString */
        @NotNull
        private String mediaType;

        /* renamed from: c, reason: from kotlin metadata and from toString */
        @Nullable
        private Drawable mediaIcon;

        /* renamed from: d, reason: from kotlin metadata and from toString */
        @Nullable
        private String userGuideOperationActivityId;

        /* renamed from: e, reason: from kotlin metadata and from toString */
        @NotNull
        private String extendDes;

        /* renamed from: f, reason: from kotlin metadata and from toString */
        @Nullable
        private String mediaIconUrl;

        public MediaBannerData() {
            this(null, null, null, null, null, null, 63, null);
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getExtendDes() {
            return this.extendDes;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final Drawable getMediaIcon() {
            return this.mediaIcon;
        }

        @Nullable
        /* renamed from: c, reason: from getter */
        public final String getMediaIconUrl() {
            return this.mediaIconUrl;
        }

        @Nullable
        /* renamed from: d, reason: from getter */
        public final String getMediaName() {
            return this.mediaName;
        }

        @NotNull
        /* renamed from: e, reason: from getter */
        public final String getMediaType() {
            return this.mediaType;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MediaBannerData)) {
                return false;
            }
            MediaBannerData mediaBannerData = (MediaBannerData) other;
            if (Intrinsics.areEqual(this.mediaName, mediaBannerData.mediaName) && Intrinsics.areEqual(this.mediaType, mediaBannerData.mediaType) && Intrinsics.areEqual(this.mediaIcon, mediaBannerData.mediaIcon) && Intrinsics.areEqual(this.userGuideOperationActivityId, mediaBannerData.userGuideOperationActivityId) && Intrinsics.areEqual(this.extendDes, mediaBannerData.extendDes) && Intrinsics.areEqual(this.mediaIconUrl, mediaBannerData.mediaIconUrl)) {
                return true;
            }
            return false;
        }

        @Nullable
        /* renamed from: f, reason: from getter */
        public final String getUserGuideOperationActivityId() {
            return this.userGuideOperationActivityId;
        }

        public final void g(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.extendDes = str;
        }

        public final void h(@Nullable Drawable drawable) {
            this.mediaIcon = drawable;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            int hashCode3;
            String str = this.mediaName;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int hashCode4 = ((hashCode * 31) + this.mediaType.hashCode()) * 31;
            Drawable drawable = this.mediaIcon;
            if (drawable == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = drawable.hashCode();
            }
            int i16 = (hashCode4 + hashCode2) * 31;
            String str2 = this.userGuideOperationActivityId;
            if (str2 == null) {
                hashCode3 = 0;
            } else {
                hashCode3 = str2.hashCode();
            }
            int hashCode5 = (((i16 + hashCode3) * 31) + this.extendDes.hashCode()) * 31;
            String str3 = this.mediaIconUrl;
            if (str3 != null) {
                i3 = str3.hashCode();
            }
            return hashCode5 + i3;
        }

        public final void i(@Nullable String str) {
            this.mediaIconUrl = str;
        }

        public final void j(@Nullable String str) {
            this.mediaName = str;
        }

        public final void k(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.mediaType = str;
        }

        public final void l(@Nullable String str) {
            this.userGuideOperationActivityId = str;
        }

        @NotNull
        public String toString() {
            return "MediaBannerData(mediaName=" + this.mediaName + ", mediaType=" + this.mediaType + ", mediaIcon=" + this.mediaIcon + ", userGuideOperationActivityId=" + this.userGuideOperationActivityId + ", extendDes=" + this.extendDes + ", mediaIconUrl=" + this.mediaIconUrl + ")";
        }

        public MediaBannerData(@Nullable String str, @NotNull String mediaType, @Nullable Drawable drawable, @Nullable String str2, @NotNull String extendDes, @Nullable String str3) {
            Intrinsics.checkNotNullParameter(mediaType, "mediaType");
            Intrinsics.checkNotNullParameter(extendDes, "extendDes");
            this.mediaName = str;
            this.mediaType = mediaType;
            this.mediaIcon = drawable;
            this.userGuideOperationActivityId = str2;
            this.extendDes = extendDes;
            this.mediaIconUrl = str3;
        }

        public /* synthetic */ MediaBannerData(String str, String str2, Drawable drawable, String str3, String str4, String str5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? null : drawable, (i3 & 8) != 0 ? null : str3, (i3 & 16) != 0 ? "" : str4, (i3 & 32) != 0 ? "" : str5);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/wink/picker/qcircle/viewmodel/c$c", "Landroidx/lifecycle/Observer;", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "metaCategories", "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.picker.qcircle.viewmodel.c$c */
    /* loaded from: classes21.dex */
    public static final class C9074c implements Observer<List<? extends MetaCategory>> {

        /* renamed from: d */
        final /* synthetic */ MutableLiveData<List<MetaCategory>> f325160d;

        /* renamed from: e */
        final /* synthetic */ MediaBannerData f325161e;

        /* renamed from: f */
        final /* synthetic */ c f325162f;

        /* renamed from: h */
        final /* synthetic */ String f325163h;

        C9074c(MutableLiveData<List<MetaCategory>> mutableLiveData, MediaBannerData mediaBannerData, c cVar, String str) {
            this.f325160d = mutableLiveData;
            this.f325161e = mediaBannerData;
            this.f325162f = cVar;
            this.f325163h = str;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v2 */
        /* JADX WARN: Type inference failed for: r5v4, types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@NotNull List<MetaCategory> metaCategories) {
            T t16;
            boolean z16;
            Intrinsics.checkNotNullParameter(metaCategories, "metaCategories");
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            String str = this.f325163h;
            Iterator<T> it = metaCategories.iterator();
            while (it.hasNext()) {
                ArrayList<MetaMaterial> arrayList = ((MetaCategory) it.next()).materials;
                Intrinsics.checkNotNullExpressionValue(arrayList, "category.materials");
                Iterator<T> it5 = arrayList.iterator();
                while (true) {
                    if (it5.hasNext()) {
                        t16 = it5.next();
                        if (Intrinsics.areEqual(((MetaMaterial) t16).f30533id, str)) {
                            break;
                        }
                    } else {
                        t16 = 0;
                        break;
                    }
                }
                objectRef.element = t16;
                if (t16 != 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            }
            if (objectRef.element == 0) {
                return;
            }
            this.f325160d.removeObserver(this);
            MediaBannerData mediaBannerData = this.f325161e;
            T t17 = objectRef.element;
            Intrinsics.checkNotNull(t17);
            mediaBannerData.j(com.tencent.mobileqq.wink.editor.c.a0((MetaMaterial) t17));
            MediaBannerData mediaBannerData2 = this.f325161e;
            T t18 = objectRef.element;
            Intrinsics.checkNotNull(t18);
            mediaBannerData2.h(URLDrawable.getDrawable(((MetaMaterial) t18).thumbUrl));
            if (!TextUtils.isEmpty(this.f325161e.getMediaName())) {
                c.g2(this.f325162f, this.f325161e, false, 2, null);
            }
        }
    }

    public c() {
        MutableLiveData<MediaBannerData> mutableLiveData = new MutableLiveData<>();
        this._mediaBannerData = mutableLiveData;
        this.mediaBannerData = mutableLiveData;
    }

    private final String M1(Intent intent) {
        HashMap hashMap;
        if (intent == null) {
            return "";
        }
        Serializable serializableExtra = intent.getSerializableExtra("key_attrs");
        if (serializableExtra instanceof HashMap) {
            hashMap = (HashMap) serializableExtra;
        } else {
            hashMap = null;
        }
        if (hashMap != null) {
            if (hashMap.containsKey(QCircleScheme.AttrQQPublish.REVITALIZE)) {
                return QCircleScheme.AttrQQPublish.REVITALIZE;
            }
            if (hashMap.containsKey("filter")) {
                return "filter";
            }
            if (hashMap.containsKey("template")) {
                return "template";
            }
            if (hashMap.containsKey("libtemplate")) {
                return "libtemplate";
            }
            if (hashMap.containsKey("sticker")) {
                return "sticker";
            }
            if (hashMap.containsKey("music")) {
                return "music";
            }
            if (hashMap.containsKey(QCircleScheme.AttrQQPublish.SUB_TAB_SOURCE_TYPE)) {
                return QCircleScheme.AttrQQPublish.SUB_TAB_SOURCE_TYPE;
            }
            if (hashMap.containsKey(QCircleScheme.AttrQQPublish.CHALLENGE_TAG)) {
                return QCircleScheme.AttrQQPublish.CHALLENGE_TAG;
            }
            if (hashMap.containsKey("tag")) {
                return "tag";
            }
            if (hashMap.containsKey(QCircleScheme.AttrQQPublish.ST_POST_POST_TYPE)) {
                return QCircleScheme.AttrQQPublish.VIDEO_COMMENT;
            }
        }
        return "";
    }

    private final void P1(Intent intent, MediaBannerData mediaBannerData) {
        HashMap<String, String> hashMap;
        boolean z16;
        String M1 = M1(intent);
        Serializable serializableExtra = intent.getSerializableExtra("key_attrs");
        if (serializableExtra instanceof HashMap) {
            hashMap = (HashMap) serializableExtra;
        } else {
            hashMap = null;
        }
        if (M1.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && hashMap != null) {
            this.hasBanner = true;
            WinkDataServiceHandler a16 = com.tencent.mobileqq.wink.edit.manager.e.a();
            if (a16 != null) {
                a16.m3("MqKuaishanEdit");
            }
            switch (M1.hashCode()) {
                case -1890252483:
                    if (M1.equals("sticker")) {
                        WinkEditorResourceManager.a1().j3();
                        mediaBannerData.k("\u8d34\u7eb8");
                        String str = hashMap.get("sticker");
                        MutableLiveData<List<MetaCategory>> I1 = WinkEditorResourceManager.a1().I1();
                        Intrinsics.checkNotNullExpressionValue(I1, "getInstance().stickerLiveData");
                        T1(str, I1, mediaBannerData);
                        return;
                    }
                    return;
                case -1486296837:
                    if (M1.equals(QCircleScheme.AttrQQPublish.REVITALIZE)) {
                        a2(hashMap, mediaBannerData);
                        return;
                    }
                    return;
                case -1321546630:
                    if (M1.equals("template")) {
                        WinkEditorResourceManager.a1().p3();
                        mediaBannerData.k("\u6a21\u677f");
                        String str2 = hashMap.get("template");
                        MutableLiveData<List<MetaCategory>> h26 = WinkEditorResourceManager.a1().h2();
                        Intrinsics.checkNotNullExpressionValue(h26, "getInstance().videoTemplateLiveData");
                        T1(str2, h26, mediaBannerData);
                        return;
                    }
                    return;
                case -1274492040:
                    if (M1.equals("filter")) {
                        WinkEditorResourceManager.a1().V2();
                        mediaBannerData.k("\u6ee4\u955c");
                        String str3 = hashMap.get("filter");
                        MutableLiveData<List<MetaCategory>> Q0 = WinkEditorResourceManager.a1().Q0();
                        Intrinsics.checkNotNullExpressionValue(Q0, "getInstance().filtersLiveData");
                        T1(str3, Q0, mediaBannerData);
                        return;
                    }
                    return;
                case -861410940:
                    if (M1.equals(QCircleScheme.AttrQQPublish.VIDEO_COMMENT)) {
                        d2(hashMap, mediaBannerData);
                        return;
                    }
                    return;
                case -811826754:
                    if (!M1.equals(QCircleScheme.AttrQQPublish.CHALLENGE_TAG)) {
                        return;
                    }
                    break;
                case 114586:
                    if (!M1.equals("tag")) {
                        return;
                    }
                    break;
                case 104263205:
                    if (M1.equals("music")) {
                        W1(hashMap, mediaBannerData);
                        return;
                    }
                    return;
                case 1088271157:
                    if (M1.equals(QCircleScheme.AttrQQPublish.SUB_TAB_SOURCE_TYPE)) {
                        R1(mediaBannerData);
                        return;
                    }
                    return;
                case 1980242431:
                    if (M1.equals("libtemplate")) {
                        S1(intent, mediaBannerData);
                        return;
                    }
                    return;
                default:
                    return;
            }
            c2(this, intent, mediaBannerData, false, 4, null);
            return;
        }
        Z1(intent, mediaBannerData);
    }

    private final void Q1(Intent intent, MediaBannerData mediaBannerData) {
        MetaMaterial metaMaterial;
        Serializable serializableExtra = intent.getSerializableExtra(QQWinkConstants.PICK_TEMPLATE_MEDIA_MODEL);
        if (serializableExtra instanceof MetaMaterial) {
            metaMaterial = (MetaMaterial) serializableExtra;
        } else {
            metaMaterial = null;
        }
        if (metaMaterial != null) {
            mediaBannerData.k("\u6a21\u677f");
            mediaBannerData.j(com.tencent.mobileqq.wink.editor.c.a0(metaMaterial));
            mediaBannerData.h(URLDrawable.getDrawable(metaMaterial.thumbUrl));
            mediaBannerData.g(com.tencent.mobileqq.wink.editor.c.S(metaMaterial));
            g2(this, mediaBannerData, false, 2, null);
        }
    }

    private final void R1(MediaBannerData mediaBannerData) {
        mediaBannerData.k("\u5708\u5b50");
        g2(this, mediaBannerData, false, 2, null);
    }

    private final void S1(Intent intent, MediaBannerData mediaBannerData) {
        Serializable serializableExtra = intent.getSerializableExtra(QQWinkConstants.PICK_TEMPLATE_MEDIA_MODEL);
        if (serializableExtra instanceof MetaMaterial) {
            MetaMaterial metaMaterial = (MetaMaterial) serializableExtra;
            mediaBannerData.j(com.tencent.mobileqq.wink.editor.c.a0(metaMaterial));
            mediaBannerData.h(URLDrawable.getDrawable(metaMaterial.thumbUrl));
            mediaBannerData.k("\u7075\u611f\u5e93\u6a21\u677f");
            g2(this, mediaBannerData, false, 2, null);
        }
    }

    private final void T1(String r26, MutableLiveData<List<MetaCategory>> materialLiveData, MediaBannerData mediaBannerData) {
        if (r26 == null) {
            return;
        }
        materialLiveData.observeForever(new C9074c(materialLiveData, mediaBannerData, this, r26));
    }

    private final void W1(HashMap<String, String> schemaData, final MediaBannerData mediaBannerData) {
        ArrayList arrayListOf;
        String str = schemaData.get("music");
        if (str != null) {
            String str2 = schemaData.get(QCircleScheme.AttrQQPublish.ORIGINAL_MUSIC_EXTEND_STRING);
            if (str2 == null) {
                str2 = "";
            }
            mediaBannerData.g(str2);
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(str);
            WinkEditorMusicHelper.D(arrayListOf, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.mobileqq.wink.picker.qcircle.viewmodel.b
                @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str3, Object obj) {
                    c.X1(c.MediaBannerData.this, this, baseRequest, z16, j3, str3, (QQCircleSmartMatchMusic$MusicInfoRsp) obj);
                }
            });
        }
    }

    public static final void X1(MediaBannerData mediaBannerData, c this$0, BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleSmartMatchMusic$MusicInfoRsp qQCircleSmartMatchMusic$MusicInfoRsp) {
        Object orNull;
        boolean z17;
        Intrinsics.checkNotNullParameter(mediaBannerData, "$mediaBannerData");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (qQCircleSmartMatchMusic$MusicInfoRsp != null) {
            List<WinkEditorMusicInfo> musicInfo = WinkEditorMusicHelper.j(WinkEditorMusicHelper.l(qQCircleSmartMatchMusic$MusicInfoRsp.musicListInfo.get()), "FAKE_CATEGORY_RECOMMEND_ID", "\u63a8\u8350");
            Intrinsics.checkNotNullExpressionValue(musicInfo, "musicInfo");
            orNull = CollectionsKt___CollectionsKt.getOrNull(musicInfo, 0);
            WinkEditorMusicInfo winkEditorMusicInfo = (WinkEditorMusicInfo) orNull;
            if (winkEditorMusicInfo != null) {
                mediaBannerData.j(winkEditorMusicInfo.q());
                mediaBannerData.k("\u97f3\u4e50");
                String albumUrl = winkEditorMusicInfo.c();
                Intrinsics.checkNotNullExpressionValue(albumUrl, "albumUrl");
                if (albumUrl.length() == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    mediaBannerData.h(ContextCompat.getDrawable(BaseApplication.context, R.drawable.ont));
                } else {
                    mediaBannerData.h(URLDrawable.getDrawable(winkEditorMusicInfo.c()));
                }
                g2(this$0, mediaBannerData, false, 2, null);
                return;
            }
            return;
        }
        w53.b.a("WinkLocalMediaBannerViewModel", "initMusicBubble, musicInfoRsp == null!");
    }

    private final void Z1(Intent intent, MediaBannerData mediaBannerData) {
        String stringExtra = intent.getStringExtra(QQWinkConstants.USER_GUIDE_TOPIC);
        if (!TextUtils.isEmpty(stringExtra)) {
            mediaBannerData.j(stringExtra);
            mediaBannerData.h(ContextCompat.getDrawable(BaseApplication.context, R.drawable.f162690ox1));
            mediaBannerData.k("\u8bdd\u9898");
            g2(this, mediaBannerData, false, 2, null);
        }
    }

    private final void a2(HashMap<String, String> hashMap, MediaBannerData mediaBannerData) {
        String str = hashMap.get(QCircleScheme.AttrQQPublish.SELECT_PAGE_BANNER_ICON);
        String str2 = hashMap.get(QCircleScheme.AttrQQPublish.SELECT_PAGE_BANNER_TIP);
        QLog.d("WinkLocalMediaBannerViewModel", 1, "initPublishPromoteBubble, icon: " + str + ", tip: " + str2);
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            mediaBannerData.j(str2);
            mediaBannerData.h(URLDrawable.getDrawable(str));
            mediaBannerData.i(str);
            mediaBannerData.k("\u6fc0\u52b1\u4fc3\u6d3b");
            g2(this, mediaBannerData, false, 2, null);
        }
    }

    private final void b2(Intent intent, MediaBannerData mediaBannerData, boolean forceUpdate) {
        mediaBannerData.j(TagRetriever.f326413a.f(intent));
        mediaBannerData.h(ContextCompat.getDrawable(BaseApplication.context, R.drawable.f162690ox1));
        mediaBannerData.k("\u8bdd\u9898");
        f2(mediaBannerData, forceUpdate);
    }

    static /* synthetic */ void c2(c cVar, Intent intent, MediaBannerData mediaBannerData, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        cVar.b2(intent, mediaBannerData, z16);
    }

    private final void d2(HashMap<String, String> schemaData, MediaBannerData mediaBannerData) {
        String str;
        String str2 = schemaData.get(QCircleScheme.AttrQQPublish.SELECT_PAGE_BANNER_ICON);
        if (Intrinsics.areEqual("1", schemaData.get(QCircleScheme.AttrQQPublish.ST_POST_POST_TYPE))) {
            str = "\u652f\u6301\u7528\u89c6\u9891\u8fdb\u884c\u8bc4\u8bba\u54e6\uff0c\u901f\u6765\u4f53\u9a8c";
        } else {
            str = "\u652f\u6301\u7528\u89c6\u9891\u8fdb\u884c\u56de\u590d\u54e6\uff0c\u901f\u6765\u4f53\u9a8c";
        }
        QLog.d("WinkLocalMediaBannerViewModel", 1, "initVideoCommentBubble, icon: " + str2 + ", tip: " + str);
        if (!TextUtils.isEmpty(str)) {
            mediaBannerData.j(str);
            mediaBannerData.k("\u89c6\u9891\u8bc4\u8bba");
            g2(this, mediaBannerData, false, 2, null);
        }
    }

    private final boolean e2(Intent intent) {
        MetaMaterial metaMaterial;
        Serializable serializableExtra = intent.getSerializableExtra(QQWinkConstants.PICK_TEMPLATE_MEDIA_MODEL);
        if (serializableExtra instanceof MetaMaterial) {
            metaMaterial = (MetaMaterial) serializableExtra;
        } else {
            metaMaterial = null;
        }
        if (metaMaterial == null || !intent.getBooleanExtra(QQWinkConstants.IS_QCIRCLE_AUTO_TEMPLATE, false) || com.tencent.mobileqq.wink.editor.c.T(metaMaterial) != MaterialType.AUTO_TEMPLATE) {
            return false;
        }
        return true;
    }

    private final void f2(MediaBannerData mediaBannerData, boolean forceUpdate) {
        if (this.hasSetGuideData && !forceUpdate) {
            return;
        }
        this.hasBanner = true;
        this.hasSetGuideData = true;
        this._mediaBannerData.postValue(mediaBannerData);
    }

    static /* synthetic */ void g2(c cVar, MediaBannerData mediaBannerData, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        cVar.f2(mediaBannerData, z16);
    }

    public static /* synthetic */ void i2(c cVar, Intent intent, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = "";
        }
        cVar.h2(intent, str);
    }

    /* renamed from: N1, reason: from getter */
    public final boolean getHasBanner() {
        return this.hasBanner;
    }

    @NotNull
    public final LiveData<MediaBannerData> O1() {
        return this.mediaBannerData;
    }

    public final void U1(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        try {
            MediaBannerData mediaBannerData = new MediaBannerData(null, null, null, null, null, null, 63, null);
            Uri data = intent.getData();
            if (data != null) {
                mediaBannerData.l(data.getQueryParameter("taskid"));
            }
            String stringExtra = intent.getStringExtra("QQWinkDataKeys-tag_name");
            if (stringExtra == null) {
                stringExtra = intent.getStringExtra("QQWinkDataKeys-challenge_tag_name");
            }
            if (!TextUtils.isEmpty(stringExtra)) {
                c2(this, intent, mediaBannerData, false, 4, null);
            } else if (e2(intent)) {
                Q1(intent, mediaBannerData);
            } else {
                P1(intent, mediaBannerData);
            }
        } catch (Exception e16) {
            w53.b.d("WinkLocalMediaBannerViewModel", "initData", e16);
        }
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "WinkLocalMediaBannerViewModel";
    }

    public final void h2(@NotNull Intent intent, @NotNull String taskId) {
        boolean z16;
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        try {
            MediaBannerData mediaBannerData = new MediaBannerData(null, null, null, null, null, null, 63, null);
            if (taskId.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                mediaBannerData.l(taskId);
            }
            String stringExtra = intent.getStringExtra("QQWinkDataKeys-tag_name");
            if (stringExtra == null) {
                stringExtra = intent.getStringExtra("QQWinkDataKeys-challenge_tag_name");
            }
            if (!TextUtils.isEmpty(stringExtra)) {
                b2(intent, mediaBannerData, true);
            }
        } catch (Exception e16) {
            w53.b.d("WinkLocalMediaBannerViewModel", "updateMediaBannerData error:", e16);
        }
    }
}
