package com.tencent.mobileqq.wink.picker.qcircle.viewmodel;

import android.content.Intent;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.editor.MaterialType;
import com.tencent.mobileqq.wink.editor.export.j;
import com.tencent.mobileqq.wink.editor.model.template.TemplatePreProcessConfig;
import com.tencent.mobileqq.wink.picker.MediaPickerScene;
import com.tencent.mobileqq.wink.picker.TabType;
import com.tencent.mobileqq.wink.picker.TemplateLibraryData;
import com.tencent.mobileqq.wink.picker.TemplateLibraryHolderInfo;
import com.tencent.mobileqq.wink.utils.y;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import e93.f;
import e93.i;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import org.light.AudioOutputConfig;
import org.light.ClipPlaceHolder;
import org.light.LightAsset;
import org.light.LightEngine;
import org.light.MaterialConfig;
import org.light.MovieController;
import org.light.RendererConfig;
import org.light.TemplateConfig;
import org.light.VideoOutputConfig;

@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u001a\u0018\u0000 \u0084\u00012\u00020\u0001:\u0002\u0085\u0001B\t\u00a2\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001a\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0002J\u001a\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u001a\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\tH\u0002J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J'\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J)\u0010\u001a\u001a\u0004\u0018\u00010\u00142\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00132\u0006\u0010\u0019\u001a\u00020\u0018H\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\b\u0010\u001f\u001a\u00020\u0004H\u0002J\b\u0010 \u001a\u00020\u0004H\u0002J\b\u0010!\u001a\u00020\u0014H\u0016J\u000e\u0010\"\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010%\u001a\u00020\u00042\u0006\u0010$\u001a\u00020#J\u000e\u0010&\u001a\u00020\u00042\u0006\u0010$\u001a\u00020#J\u000e\u0010)\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020'J\u0014\u0010-\u001a\u00020\u00042\f\u0010,\u001a\b\u0012\u0004\u0012\u00020+0*J\u000e\u0010/\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\u0018J\u000e\u00100\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u0018J\u0006\u00101\u001a\u00020\u000bJ\u0006\u00102\u001a\u00020\u000bJ\b\u00104\u001a\u0004\u0018\u000103R\u0018\u00107\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R(\u0010=\u001a\u0004\u0018\u00010\u00062\b\u00108\u001a\u0004\u0018\u00010\u00068\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R$\u0010C\u001a\u00020>2\u0006\u00108\u001a\u00020>8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR$\u0010I\u001a\u00020D2\u0006\u00108\u001a\u00020D8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR*\u0010Q\u001a\u00020\u000b2\u0006\u0010J\u001a\u00020\u000b8\u0006@BX\u0086\u000e\u00a2\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR$\u0010V\u001a\u00020\u00182\u0006\u00108\u001a\u00020\u00188\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bR\u0010S\u001a\u0004\bT\u0010UR\u0016\u0010X\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010SR\"\u0010\\\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bY\u0010L\u001a\u0004\bZ\u0010N\"\u0004\b[\u0010PR\"\u0010_\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bS\u0010L\u001a\u0004\b]\u0010N\"\u0004\b^\u0010PR\"\u0010d\u001a\u0010\u0012\f\u0012\n a*\u0004\u0018\u00010\u00180\u00180`8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bb\u0010cR\u001d\u0010i\u001a\b\u0012\u0004\u0012\u00020\u00180*8\u0006\u00a2\u0006\f\n\u0004\be\u0010f\u001a\u0004\bg\u0010hR \u0010o\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020l0k0j8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bm\u0010nR#\u0010r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020l0k0*8\u0006\u00a2\u0006\f\n\u0004\bp\u0010f\u001a\u0004\bq\u0010hR\u001a\u0010t\u001a\b\u0012\u0004\u0012\u00020\u00140`8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bs\u0010cR\u001d\u0010w\u001a\b\u0012\u0004\u0012\u00020\u00140*8\u0006\u00a2\u0006\f\n\u0004\bu\u0010f\u001a\u0004\bv\u0010hR\u001a\u0010y\u001a\b\u0012\u0004\u0012\u00020#0`8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bx\u0010cR\u001d\u0010|\u001a\b\u0012\u0004\u0012\u00020#0*8\u0006\u00a2\u0006\f\n\u0004\bz\u0010f\u001a\u0004\b{\u0010hR\u001a\u0010~\u001a\b\u0012\u0004\u0012\u00020#0`8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b}\u0010cR\u001f\u0010\u0081\u0001\u001a\b\u0012\u0004\u0012\u00020#0*8\u0006\u00a2\u0006\r\n\u0004\b\u007f\u0010f\u001a\u0005\b\u0080\u0001\u0010h\u00a8\u0006\u0086\u0001"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qcircle/viewmodel/QCircleTemplateMediaPickerViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "Landroid/content/Intent;", "intent", "", "g2", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, SemanticAttributes.DbSystemValues.H2, "Lorg/light/LightAsset;", "f2", "", "isDelete", "t2", "i2", "asset", "w2", "y2", "c2", "", "", "holderDescription", "d2", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;[Ljava/lang/String;)Z", "", "mediaIndex", "S1", "([Ljava/lang/String;I)Ljava/lang/String;", "Le93/b;", "action", "P1", "v2", NowProxyConstants.AccountInfoKey.A2, "getLogTag", "e2", "Landroid/view/View;", "view", "p2", "q2", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "info", ICustomDataEditor.NUMBER_PARAM_2, "Landroidx/lifecycle/LiveData;", "Le93/a;", "mediaChangeLiveData", "r2", "holderLocation", "z2", "l2", "m2", "o2", "Lcom/tencent/mobileqq/wink/picker/d;", "Q1", "i", "Ljava/lang/Integer;", "deleteHolderIndex", "<set-?>", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "b2", "()Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "templateLibMaterial", "Lcom/tencent/mobileqq/wink/picker/MediaPickerScene;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/wink/picker/MediaPickerScene;", "U1", "()Lcom/tencent/mobileqq/wink/picker/MediaPickerScene;", "mediaPickerScene", "Lcom/tencent/mobileqq/wink/picker/TabType;", "D", "Lcom/tencent/mobileqq/wink/picker/TabType;", "Z1", "()Lcom/tencent/mobileqq/wink/picker/TabType;", "tabType", "value", "E", "Z", "X1", "()Z", "x2", "(Z)V", "needFaceDetect", UserInfo.SEX_FEMALE, "I", "T1", "()I", "mediaHolderCount", "G", "toReplacedMediaIndex", "H", "j2", "setAutoTempPicker", "isAutoTempPicker", "k2", "setFragmentCollapsed", "isFragmentCollapsed", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "J", "Landroidx/lifecycle/MutableLiveData;", "_firstEmptyHolderIndex", "K", "Landroidx/lifecycle/LiveData;", "R1", "()Landroidx/lifecycle/LiveData;", "firstEmptyHolderIndex", "Landroidx/lifecycle/MediatorLiveData;", "", "Lcom/tencent/mobileqq/wink/picker/TemplateLibraryHolderInfo;", "L", "Landroidx/lifecycle/MediatorLiveData;", "_templateHolderInfo", "M", ICustomDataEditor.STRING_ARRAY_PARAM_2, "templateHolderInfo", "N", "_mediaSelectFailedMsg", "P", "W1", "mediaSelectFailedMsg", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "_itemClicked", BdhLogUtil.LogTag.Tag_Req, "getItemClicked", "itemClicked", ExifInterface.LATITUDE_SOUTH, "_itemSelected", "T", "getItemSelected", "itemSelected", "<init>", "()V", "U", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class QCircleTemplateMediaPickerViewModel extends BaseViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private MediaPickerScene mediaPickerScene = MediaPickerScene.TEMPLATE_LIBRARY;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private TabType tabType = TabType.ALL_MEDIA;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean needFaceDetect;

    /* renamed from: F, reason: from kotlin metadata */
    private int mediaHolderCount;

    /* renamed from: G, reason: from kotlin metadata */
    private int toReplacedMediaIndex;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean isAutoTempPicker;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean isFragmentCollapsed;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Integer> _firstEmptyHolderIndex;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Integer> firstEmptyHolderIndex;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final MediatorLiveData<List<TemplateLibraryHolderInfo>> _templateHolderInfo;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final LiveData<List<TemplateLibraryHolderInfo>> templateHolderInfo;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<String> _mediaSelectFailedMsg;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final LiveData<String> mediaSelectFailedMsg;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<View> _itemClicked;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final LiveData<View> itemClicked;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<View> _itemSelected;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final LiveData<View> itemSelected;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer deleteHolderIndex;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MetaMaterial templateLibMaterial;

    public QCircleTemplateMediaPickerViewModel() {
        MutableLiveData<Integer> mutableLiveData = new MutableLiveData<>(0);
        this._firstEmptyHolderIndex = mutableLiveData;
        this.firstEmptyHolderIndex = mutableLiveData;
        MediatorLiveData<List<TemplateLibraryHolderInfo>> mediatorLiveData = new MediatorLiveData<>();
        this._templateHolderInfo = mediatorLiveData;
        this.templateHolderInfo = mediatorLiveData;
        MutableLiveData<String> mutableLiveData2 = new MutableLiveData<>();
        this._mediaSelectFailedMsg = mutableLiveData2;
        this.mediaSelectFailedMsg = mutableLiveData2;
        MutableLiveData<View> mutableLiveData3 = new MutableLiveData<>();
        this._itemClicked = mutableLiveData3;
        this.itemClicked = mutableLiveData3;
        MutableLiveData<View> mutableLiveData4 = new MutableLiveData<>();
        this._itemSelected = mutableLiveData4;
        this.itemSelected = mutableLiveData4;
        mediatorLiveData.setValue(new ArrayList());
    }

    private final void A2() {
        boolean z16;
        List<TemplateLibraryHolderInfo> value = this.templateHolderInfo.getValue();
        if (value != null) {
            MutableLiveData<Integer> mutableLiveData = this._firstEmptyHolderIndex;
            Iterator<TemplateLibraryHolderInfo> it = value.iterator();
            int i3 = 0;
            while (true) {
                if (it.hasNext()) {
                    if (it.next().getMediaInfo() == null) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        break;
                    } else {
                        i3++;
                    }
                } else {
                    i3 = -1;
                    break;
                }
            }
            mutableLiveData.setValue(Integer.valueOf(i3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P1(e93.b action) {
        TemplateLibraryHolderInfo templateLibraryHolderInfo;
        Integer value = this._firstEmptyHolderIndex.getValue();
        if (value != null) {
            List<TemplateLibraryHolderInfo> value2 = this._templateHolderInfo.getValue();
            if (value2 != null) {
                templateLibraryHolderInfo = value2.get(value.intValue());
            } else {
                templateLibraryHolderInfo = null;
            }
            if (templateLibraryHolderInfo != null) {
                templateLibraryHolderInfo.setMediaInfo(action.getAddedMedia());
            }
            MediatorLiveData<List<TemplateLibraryHolderInfo>> mediatorLiveData = this._templateHolderInfo;
            mediatorLiveData.setValue(mediatorLiveData.getValue());
            A2();
        }
    }

    private final String S1(String[] holderDescription, int mediaIndex) {
        if (holderDescription == null) {
            return null;
        }
        if (mediaIndex < holderDescription.length) {
            return holderDescription[mediaIndex];
        }
        return holderDescription[holderDescription.length - 1];
    }

    private final void c2(MetaMaterial material) {
        TemplatePreProcessConfig H0 = com.tencent.mobileqq.wink.editor.c.H0(material);
        if (H0 == null) {
            return;
        }
        if (H0.getImageOnly()) {
            this.tabType = TabType.ONLY_IMAGE;
        }
        x2(H0.isNeedFaceDetect());
    }

    private final boolean d2(MetaMaterial material, String[] holderDescription) {
        TemplatePreProcessConfig H0;
        boolean z16;
        float duration;
        int i3 = 0;
        if (holderDescription == null || (H0 = com.tencent.mobileqq.wink.editor.c.H0(material)) == null) {
            return false;
        }
        if (H0.getImageOnly()) {
            this.tabType = TabType.ONLY_IMAGE;
        }
        x2(H0.isNeedFaceDetect());
        List<TemplatePreProcessConfig.Media> medias = H0.getMedias();
        if (medias != null && !medias.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        boolean b06 = com.tencent.mobileqq.wink.editor.c.b0(material);
        List<TemplatePreProcessConfig.Media> medias2 = H0.getMedias();
        Intrinsics.checkNotNullExpressionValue(medias2, "config.medias");
        for (Object obj : medias2) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            TemplatePreProcessConfig.Media media = (TemplatePreProcessConfig.Media) obj;
            List<TemplateLibraryHolderInfo> value = this._templateHolderInfo.getValue();
            if (value != null) {
                if (b06) {
                    duration = 0.0f;
                } else {
                    duration = media.getDuration() / 1000000.0f;
                }
                value.add(new TemplateLibraryHolderInfo(null, duration, S1(holderDescription, i3)));
            }
            i3 = i16;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x00a4, code lost:
    
        if (r2 != false) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final LightAsset f2(MetaMaterial material) {
        Integer num;
        boolean z16;
        boolean z17;
        boolean z18;
        y yVar = y.f326739a;
        BaseApplication context = BaseApplication.context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        yVar.b(context);
        String m3 = WinkEditorResourceManager.a1().m(material);
        Intrinsics.checkNotNullExpressionValue(m3, "getInstance().getDownloadFolder(material)");
        w53.b.f("QCircleTemplateMediaPickerViewModel", "initFromAsset: path: " + m3 + ", isFileExits: " + WinkEditorResourceManager.a1().s(material));
        LightAsset Load = LightAsset.Load(m3, 100);
        if (Load != null) {
            num = Integer.valueOf(Load.getErrorCode());
        } else {
            num = null;
        }
        w53.b.c("QCircleTemplateMediaPickerViewModel", "initFromAsset: asset errorCode: " + num);
        boolean z19 = false;
        if (Load != null && Load.getErrorCode() == -2) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (Load != null && Load.getErrorCode() == -400) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                if (Load != null && Load.getErrorCode() == -500) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (!z18) {
                    if (Load != null && Load.getErrorCode() == -1400) {
                        z19 = true;
                    }
                }
            }
        }
        t2(material, true);
        w2(Load, material);
        y2(Load);
        return Load;
    }

    private final void g2(Intent intent) {
        if (this.templateLibMaterial == null) {
            return;
        }
        if (!j.K()) {
            w53.b.c("QCircleTemplateMediaPickerViewModel", "initLibraryData:so load error!");
            return;
        }
        if (this.isAutoTempPicker) {
            intent.putExtra(QQWinkConstants.IS_QCIRCLE_AUTO_TEMPLATE, true);
            MetaMaterial metaMaterial = this.templateLibMaterial;
            Intrinsics.checkNotNull(metaMaterial);
            f2(metaMaterial);
            return;
        }
        MetaMaterial metaMaterial2 = this.templateLibMaterial;
        Intrinsics.checkNotNull(metaMaterial2);
        h2(metaMaterial2);
    }

    private final void h2(MetaMaterial material) {
        LightEngine make;
        ClipPlaceHolder[] clipPlaceHolders;
        long j3;
        float f16;
        LightAsset f26 = f2(material);
        int i3 = 0;
        Object[] array = new Regex("\uff5c").split(com.tencent.mobileqq.wink.editor.c.S(material), 0).toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        String[] strArr = (String[]) array;
        if (!d2(material, strArr) && (make = LightEngine.make(new VideoOutputConfig(30.0f, 0), new AudioOutputConfig(), new RendererConfig())) != null) {
            boolean b06 = com.tencent.mobileqq.wink.editor.c.b0(material);
            MovieController assetForMovie = make.setAssetForMovie(f26);
            if (assetForMovie != null && (clipPlaceHolders = assetForMovie.getClipPlaceHolders()) != null) {
                Intrinsics.checkNotNullExpressionValue(clipPlaceHolders, "clipPlaceHolders");
                int length = clipPlaceHolders.length;
                int i16 = 0;
                int i17 = 0;
                while (i16 < length) {
                    ClipPlaceHolder clipPlaceHolder = clipPlaceHolders[i16];
                    int i18 = i17 + 1;
                    List<TemplateLibraryHolderInfo> value = this._templateHolderInfo.getValue();
                    if (value != null) {
                        if (b06) {
                            f16 = 0.0f;
                        } else {
                            if (clipPlaceHolder != null) {
                                j3 = clipPlaceHolder.contentDuration;
                            } else {
                                j3 = 0;
                            }
                            f16 = ((float) j3) / 1000000.0f;
                        }
                        value.add(new TemplateLibraryHolderInfo(null, f16, S1(strArr, i17)));
                    }
                    i16++;
                    i17 = i18;
                }
            }
            make.release();
        }
        List<TemplateLibraryHolderInfo> value2 = this._templateHolderInfo.getValue();
        if (value2 != null) {
            i3 = value2.size();
        }
        this.mediaHolderCount = i3;
    }

    private final void i2(Intent intent, MetaMaterial material) {
        this.mediaHolderCount = 1;
        this.toReplacedMediaIndex = intent.getIntExtra(QQWinkConstants.PICK_TEMPLATE_MEDIA_INDEX, 0);
        List<TemplateLibraryHolderInfo> value = this._templateHolderInfo.getValue();
        TabType tabType = null;
        String str = null;
        if (value != null) {
            value.add(new TemplateLibraryHolderInfo(null, intent.getFloatExtra(QQWinkConstants.MEDIA_PICKER_TEMPLATE_LIBRARY_HOLDER_TIME_SLOT, 0.0f), HardCodeUtil.qqStr(R.string.f216465yd)));
        }
        boolean booleanExtra = intent.getBooleanExtra(QQWinkConstants.PICK_IS_FIRST_TEMPLATE, false);
        if (material != null) {
            if (j.K()) {
                LightAsset Load = LightAsset.Load(WinkEditorResourceManager.a1().m(material), 100);
                w2(Load, material);
                y2(Load);
            }
            Map<String, String> map = material.additionalFields;
            if (map != null) {
                str = map.get("templatePreprocessConfig");
            }
            if (str != null) {
                c2(material);
                return;
            }
            return;
        }
        Serializable serializableExtra = intent.getSerializableExtra(QQWinkConstants.MEDIA_PICKER_TAB_TYPE);
        if (serializableExtra instanceof TabType) {
            tabType = (TabType) serializableExtra;
        }
        if (tabType == null) {
            tabType = TabType.ALL_MEDIA;
        }
        this.tabType = tabType;
        if (booleanExtra) {
            this.tabType = TabType.ONLY_IMAGE;
        }
        x2(intent.getBooleanExtra(QQWinkConstants.MEDIA_PICKER_NEED_FACE_DETECT, false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void t2(final MetaMaterial material, final boolean isDelete) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.qcircle.viewmodel.d
            @Override // java.lang.Runnable
            public final void run() {
                QCircleTemplateMediaPickerViewModel.u2(MetaMaterial.this, isDelete);
            }
        }, 64, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u2(MetaMaterial material, boolean z16) {
        Intrinsics.checkNotNullParameter(material, "$material");
        try {
            w53.b.c("QCircleTemplateMediaPickerViewModel", "printFileMd5: template filePath:" + WinkEditorResourceManager.a1().X0(material));
            if (z16) {
                FileUtils.deleteDirectory(WinkEditorResourceManager.a1().m(material));
            }
        } catch (Exception e16) {
            w53.b.c("QCircleTemplateMediaPickerViewModel", "printFileMd5: template md5 exception: " + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v2() {
        TemplateLibraryHolderInfo templateLibraryHolderInfo;
        Integer num = this.deleteHolderIndex;
        if (num != null) {
            int intValue = num.intValue();
            List<TemplateLibraryHolderInfo> value = this._templateHolderInfo.getValue();
            if (value != null) {
                templateLibraryHolderInfo = value.get(intValue);
            } else {
                templateLibraryHolderInfo = null;
            }
            if (templateLibraryHolderInfo != null) {
                templateLibraryHolderInfo.setMediaInfo(null);
            }
            MediatorLiveData<List<TemplateLibraryHolderInfo>> mediatorLiveData = this._templateHolderInfo;
            mediatorLiveData.setValue(mediatorLiveData.getValue());
            A2();
        }
    }

    private final void w2(LightAsset asset, MetaMaterial material) {
        boolean z16;
        boolean z17;
        TemplateConfig movieConfig;
        TemplateConfig movieConfig2;
        TemplateConfig movieConfig3;
        boolean z18 = true;
        if (asset != null && (movieConfig3 = asset.getMovieConfig()) != null && movieConfig3.type == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && 1 != com.tencent.mobileqq.wink.editor.c.V(material)) {
            if (asset != null && (movieConfig2 = asset.getMovieConfig()) != null && movieConfig2.type == 2) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                this.tabType = TabType.ALL_MEDIA;
                return;
            }
            if (asset == null || (movieConfig = asset.getMovieConfig()) == null || movieConfig.type != 0) {
                z18 = false;
            }
            if (z18) {
                this.tabType = TabType.ONLY_VIDEO;
                return;
            }
            return;
        }
        this.tabType = TabType.ONLY_IMAGE;
    }

    private final void x2(boolean z16) {
        boolean z17;
        if (z16 && this.tabType == TabType.ONLY_IMAGE) {
            z17 = true;
        } else {
            z17 = false;
        }
        this.needFaceDetect = z17;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0049 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void y2(LightAsset asset) {
        MaterialConfig[] materialConfigs;
        String str;
        boolean z16;
        boolean isBlank;
        if (asset != null && (materialConfigs = asset.getMaterialConfigs()) != null) {
            for (MaterialConfig materialConfig : materialConfigs) {
                HashMap<String, String> hashMap = materialConfig.aiFilterList;
                if (hashMap != null) {
                    str = hashMap.get("ai.face");
                } else {
                    str = null;
                }
                if (str != null) {
                    isBlank = StringsKt__StringsJVMKt.isBlank(str);
                    if (!isBlank) {
                        z16 = false;
                        if (z16) {
                            try {
                                if (new JSONObject(str).length() > 0) {
                                    w53.b.f("QCircleTemplateMediaPickerViewModel", "setNeedFaceDetectFromAsset true from asset");
                                    x2(true);
                                    return;
                                }
                                continue;
                            } catch (JSONException e16) {
                                e16.printStackTrace();
                            }
                        }
                    }
                }
                z16 = true;
                if (z16) {
                }
            }
        }
    }

    @Nullable
    public final TemplateLibraryData Q1() {
        MetaMaterial metaMaterial = this.templateLibMaterial;
        if (metaMaterial == null) {
            return null;
        }
        Intrinsics.checkNotNull(metaMaterial);
        return new TemplateLibraryData(metaMaterial, this.needFaceDetect, this.toReplacedMediaIndex);
    }

    @NotNull
    public final LiveData<Integer> R1() {
        return this.firstEmptyHolderIndex;
    }

    /* renamed from: T1, reason: from getter */
    public final int getMediaHolderCount() {
        return this.mediaHolderCount;
    }

    @NotNull
    /* renamed from: U1, reason: from getter */
    public final MediaPickerScene getMediaPickerScene() {
        return this.mediaPickerScene;
    }

    @NotNull
    public final LiveData<String> W1() {
        return this.mediaSelectFailedMsg;
    }

    /* renamed from: X1, reason: from getter */
    public final boolean getNeedFaceDetect() {
        return this.needFaceDetect;
    }

    @NotNull
    /* renamed from: Z1, reason: from getter */
    public final TabType getTabType() {
        return this.tabType;
    }

    @NotNull
    public final LiveData<List<TemplateLibraryHolderInfo>> a2() {
        return this.templateHolderInfo;
    }

    @Nullable
    /* renamed from: b2, reason: from getter */
    public final MetaMaterial getTemplateLibMaterial() {
        return this.templateLibMaterial;
    }

    public final void e2(@NotNull Intent intent) {
        MediaPickerScene mediaPickerScene;
        MetaMaterial metaMaterial;
        MaterialType materialType;
        boolean z16;
        Intrinsics.checkNotNullParameter(intent, "intent");
        Serializable serializableExtra = intent.getSerializableExtra(QQWinkConstants.MEDIA_PICKER_SCENE);
        MetaMaterial metaMaterial2 = null;
        if (serializableExtra instanceof MediaPickerScene) {
            mediaPickerScene = (MediaPickerScene) serializableExtra;
        } else {
            mediaPickerScene = null;
        }
        if (mediaPickerScene == null) {
            mediaPickerScene = MediaPickerScene.TEMPLATE_LIBRARY;
        }
        this.mediaPickerScene = mediaPickerScene;
        Serializable serializableExtra2 = intent.getSerializableExtra(QQWinkConstants.PICK_TEMPLATE_MEDIA_MODEL);
        if (serializableExtra2 instanceof MetaMaterial) {
            metaMaterial = (MetaMaterial) serializableExtra2;
        } else {
            metaMaterial = null;
        }
        if (metaMaterial != null) {
            materialType = com.tencent.mobileqq.wink.editor.c.T(metaMaterial);
        } else {
            materialType = null;
        }
        if (materialType == MaterialType.AUTO_TEMPLATE) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.isAutoTempPicker = z16;
        Serializable serializableExtra3 = intent.getSerializableExtra(QQWinkConstants.PICK_TEMPLATE_MEDIA_MODEL);
        if (serializableExtra3 instanceof MetaMaterial) {
            metaMaterial2 = (MetaMaterial) serializableExtra3;
        }
        this.templateLibMaterial = metaMaterial2;
        MediaPickerScene mediaPickerScene2 = this.mediaPickerScene;
        if (mediaPickerScene2 != MediaPickerScene.TEMPLATE_LIBRARY && mediaPickerScene2 != MediaPickerScene.TEMPLATE_ZSHOW) {
            i2(intent, metaMaterial2);
            return;
        }
        g2(intent);
        intent.putExtra(QQWinkConstants.MEDIA_PICKER_TAB_TYPE, this.tabType);
        intent.putExtra(QQWinkConstants.MEDIA_PICKER_NEED_FACE_DETECT, this.needFaceDetect);
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QCircleTemplateMediaPickerViewModel";
    }

    /* renamed from: j2, reason: from getter */
    public final boolean getIsAutoTempPicker() {
        return this.isAutoTempPicker;
    }

    /* renamed from: k2, reason: from getter */
    public final boolean getIsFragmentCollapsed() {
        return this.isFragmentCollapsed;
    }

    public final boolean l2(int holderLocation) {
        if (!o2()) {
            return true;
        }
        MetaMaterial metaMaterial = this.templateLibMaterial;
        Intrinsics.checkNotNull(metaMaterial);
        if (holderLocation < com.tencent.mobileqq.wink.editor.c.W(metaMaterial)) {
            return true;
        }
        return false;
    }

    public final boolean m2() {
        int i3;
        boolean z16;
        if (!o2()) {
            return false;
        }
        List<TemplateLibraryHolderInfo> value = this._templateHolderInfo.getValue();
        Intrinsics.checkNotNull(value);
        List<TemplateLibraryHolderInfo> list = value;
        if ((list instanceof Collection) && list.isEmpty()) {
            i3 = 0;
        } else {
            Iterator<T> it = list.iterator();
            i3 = 0;
            while (it.hasNext()) {
                if (((TemplateLibraryHolderInfo) it.next()).getMediaInfo() != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16 && (i3 = i3 + 1) < 0) {
                    CollectionsKt__CollectionsKt.throwCountOverflow();
                }
            }
        }
        MetaMaterial metaMaterial = this.templateLibMaterial;
        Intrinsics.checkNotNull(metaMaterial);
        if (i3 < com.tencent.mobileqq.wink.editor.c.W(metaMaterial)) {
            return false;
        }
        return true;
    }

    public final boolean n2(@NotNull LocalMediaInfo info) {
        MediaPickerScene mediaPickerScene;
        List<TemplateLibraryHolderInfo> value;
        Object orNull;
        Intrinsics.checkNotNullParameter(info, "info");
        if (i.I(info) && (mediaPickerScene = this.mediaPickerScene) != MediaPickerScene.TEMPLATE_ZSHOW && mediaPickerScene != MediaPickerScene.TEMPLATE_ZSHOW_REPLACE && (value = this._templateHolderInfo.getValue()) != null) {
            Integer value2 = this._firstEmptyHolderIndex.getValue();
            if (value2 == null) {
                value2 = -1;
            }
            orNull = CollectionsKt___CollectionsKt.getOrNull(value, value2.intValue());
            TemplateLibraryHolderInfo templateLibraryHolderInfo = (TemplateLibraryHolderInfo) orNull;
            if (templateLibraryHolderInfo != null && templateLibraryHolderInfo.getHolderTimeSlot() > ((float) (info.mDuration / 1000))) {
                MutableLiveData<String> mutableLiveData = this._mediaSelectFailedMsg;
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format(Locale.CHINA, "%.1fs", Arrays.copyOf(new Object[]{Float.valueOf(templateLibraryHolderInfo.getHolderTimeSlot())}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(locale, format, *args)");
                mutableLiveData.setValue("\u89c6\u9891\u65f6\u957f\u4e0d\u80fd\u5c11\u4e8e" + format);
                return false;
            }
        }
        return true;
    }

    public final boolean o2() {
        MetaMaterial metaMaterial;
        boolean z16;
        if (this.mediaPickerScene != MediaPickerScene.TEMPLATE_LIBRARY || this._templateHolderInfo.getValue() == null || (metaMaterial = this.templateLibMaterial) == null) {
            return false;
        }
        Intrinsics.checkNotNull(metaMaterial);
        if (com.tencent.mobileqq.wink.editor.c.W(metaMaterial) <= 0) {
            return false;
        }
        MetaMaterial metaMaterial2 = this.templateLibMaterial;
        Intrinsics.checkNotNull(metaMaterial2);
        if (com.tencent.mobileqq.wink.editor.c.H0(metaMaterial2) != null) {
            MetaMaterial metaMaterial3 = this.templateLibMaterial;
            Intrinsics.checkNotNull(metaMaterial3);
            TemplatePreProcessConfig H0 = com.tencent.mobileqq.wink.editor.c.H0(metaMaterial3);
            Intrinsics.checkNotNull(H0);
            List<TemplatePreProcessConfig.Media> medias = H0.getMedias();
            if (medias != null && !medias.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                return false;
            }
        }
        return true;
    }

    public final void p2(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this._itemClicked.postValue(view);
    }

    public final void q2(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this._itemSelected.postValue(view);
    }

    public final void r2(@NotNull LiveData<e93.a> mediaChangeLiveData) {
        Intrinsics.checkNotNullParameter(mediaChangeLiveData, "mediaChangeLiveData");
        MediatorLiveData<List<TemplateLibraryHolderInfo>> mediatorLiveData = this._templateHolderInfo;
        final Function1<e93.a, Unit> function1 = new Function1<e93.a, Unit>() { // from class: com.tencent.mobileqq.wink.picker.qcircle.viewmodel.QCircleTemplateMediaPickerViewModel$observeSelectedMediaChanged$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(e93.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(e93.a it) {
                if (it instanceof e93.b) {
                    QCircleTemplateMediaPickerViewModel qCircleTemplateMediaPickerViewModel = QCircleTemplateMediaPickerViewModel.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    qCircleTemplateMediaPickerViewModel.P1((e93.b) it);
                } else if (it instanceof f) {
                    QCircleTemplateMediaPickerViewModel.this.v2();
                }
            }
        };
        mediatorLiveData.addSource(mediaChangeLiveData, new Observer() { // from class: com.tencent.mobileqq.wink.picker.qcircle.viewmodel.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QCircleTemplateMediaPickerViewModel.s2(Function1.this, obj);
            }
        });
    }

    public final int z2(int holderLocation) {
        LocalMediaInfo localMediaInfo;
        TemplateLibraryHolderInfo templateLibraryHolderInfo;
        int i3 = 0;
        for (int i16 = 0; i16 < holderLocation; i16++) {
            List<TemplateLibraryHolderInfo> value = this.templateHolderInfo.getValue();
            if (value != null && (templateLibraryHolderInfo = value.get(i16)) != null) {
                localMediaInfo = templateLibraryHolderInfo.getMediaInfo();
            } else {
                localMediaInfo = null;
            }
            if (localMediaInfo != null) {
                i3++;
            }
        }
        this.deleteHolderIndex = Integer.valueOf(holderLocation);
        return i3;
    }
}
