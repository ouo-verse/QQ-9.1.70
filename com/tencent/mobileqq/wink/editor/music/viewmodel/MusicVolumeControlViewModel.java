package com.tencent.mobileqq.wink.editor.music.viewmodel;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mobileqq.wink.editor.music.viewmodel.VolumeValueCache;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.videocut.model.MediaClip;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0083\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010%\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0018*\u0003;Eh\u0018\u0000 \u008e\u00012\u00020\u0001:\u0004\u008f\u0001\u0090\u0001B\t\u00a2\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0016\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\u0014\u0010\u000f\u001a\u00020\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u001a\u0010\u0014\u001a\u00020\u00052\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00070\u0011J%\u0010\u0016\u001a\u00020\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u0002J\u000e\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0002J\u0006\u0010\u001c\u001a\u00020\tJ\u000e\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\tJ\u000e\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0002J\u000e\u0010 \u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0002J\u001e\u0010\"\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u0002J\u001a\u0010#\u001a\u00020\u00072\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00070\u0011J\u0016\u0010$\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u000e\u0010&\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u0007J\u000e\u0010'\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u0007J\u000e\u0010(\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u0007J\u0006\u0010)\u001a\u00020\u0005J\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00070*J\u0017\u0010,\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b,\u0010-J\u0006\u0010.\u001a\u00020\u0002J\u0006\u0010/\u001a\u00020\u0007J\u0006\u00100\u001a\u00020\u0005J\u0006\u00101\u001a\u00020\u0007J\u0006\u00102\u001a\u00020\u0007J\u0006\u00103\u001a\u00020\u0002J\u000e\u00104\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0002J\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000205J\u001c\u00108\u001a\u00020\u00052\u0014\u00107\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u000105J\b\u0010:\u001a\u000209H\u0016R\u0014\u0010>\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u001d\u0010D\u001a\b\u0012\u0004\u0012\u00020\t0?8\u0006\u00a2\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR\u0014\u0010H\u001a\u00020E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u001d\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00070?8\u0006\u00a2\u0006\f\n\u0004\bI\u0010A\u001a\u0004\bJ\u0010CR.\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00070*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\"\u0010S\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00070*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010MR\u001a\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00070T8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u001d\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00070?8\u0006\u00a2\u0006\f\n\u0004\bX\u0010A\u001a\u0004\bY\u0010CR\u001a\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00020T8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b[\u0010VR\u001d\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00020?8\u0006\u00a2\u0006\f\n\u0004\b]\u0010A\u001a\u0004\b^\u0010CR$\u0010g\u001a\u0004\u0018\u00010`8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\ba\u0010b\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR\u0014\u0010k\u001a\u00020h8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bi\u0010jR\u001d\u0010n\u001a\b\u0012\u0004\u0012\u00020\u00070?8\u0006\u00a2\u0006\f\n\u0004\bl\u0010A\u001a\u0004\bm\u0010CR\u001a\u0010p\u001a\b\u0012\u0004\u0012\u00020\u00070T8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bo\u0010VR\u001d\u0010s\u001a\b\u0012\u0004\u0012\u00020\u00070?8\u0006\u00a2\u0006\f\n\u0004\bq\u0010A\u001a\u0004\br\u0010CR\u001a\u0010u\u001a\b\u0012\u0004\u0012\u00020\u00020T8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bt\u0010VR\u001d\u0010x\u001a\b\u0012\u0004\u0012\u00020\u00020?8\u0006\u00a2\u0006\f\n\u0004\bv\u0010A\u001a\u0004\bw\u0010CR\u0014\u0010|\u001a\u00020y8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bz\u0010{R&\u0010\u0083\u0001\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0004\b}\u0010~\u001a\u0005\b\u007f\u0010\u0080\u0001\"\u0006\b\u0081\u0001\u0010\u0082\u0001R(\u0010\u0087\u0001\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\u0084\u0001\u0010~\u001a\u0006\b\u0085\u0001\u0010\u0080\u0001\"\u0006\b\u0086\u0001\u0010\u0082\u0001R!\u0010\u008b\u0001\u001a\b\u0012\u0004\u0012\u00020\u00020T8\u0006\u00a2\u0006\u000f\n\u0005\b\u0088\u0001\u0010V\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001\u00a8\u0006\u0091\u0001"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicVolumeControlViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "enableBgm", "isUseTemplate", "", "B2", "", "value", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicVolumeControlViewModel$VolumeType;", "sliderType", "S1", "", "Lcom/tencent/videocut/model/MediaClip;", "mediaClips", "p2", "R1", "", "", "mediaClipVolumes", "Q1", "isChangedManually", "q2", "(Ljava/util/List;Ljava/lang/Boolean;)V", "enable", "forceClose", "y2", "K2", "f2", "type", Constants.MMCCID, "H2", "I2", "fromClick", "o2", "j2", ICustomDataEditor.NUMBER_PARAM_2, InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "N2", "L2", Constants.BASE_IN_PLUGIN_VERSION, "M2", "", "d2", "E2", "(Ljava/lang/Boolean;)V", ICustomDataEditor.STRING_PARAM_2, "b2", "P1", "Z1", "c2", "m2", "x2", "Lkotlin/Pair;", "W1", "pair", "w2", "", "getLogTag", "com/tencent/mobileqq/wink/editor/music/viewmodel/MusicVolumeControlViewModel$c", "i", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicVolumeControlViewModel$c;", "_curOperateBgmType", "Landroidx/lifecycle/LiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "X1", "()Landroidx/lifecycle/LiveData;", "curOperateBgmType", "com/tencent/mobileqq/wink/editor/music/viewmodel/MusicVolumeControlViewModel$d", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicVolumeControlViewModel$d;", "_originLiveData", "D", SemanticAttributes.DbSystemValues.H2, "originLiveData", "E", "Ljava/util/Map;", "e2", "()Ljava/util/Map;", "F2", "(Ljava/util/Map;)V", UserInfo.SEX_FEMALE, "backupMediaClipVolumes", "Landroidx/lifecycle/MutableLiveData;", "G", "Landroidx/lifecycle/MutableLiveData;", "_originSliderLiveData", "H", "i2", "originSliderLiveData", "I", "_originEnabledLiveData", "J", "g2", "originEnabledLiveData", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/c;", "K", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/c;", ICustomDataEditor.STRING_ARRAY_PARAM_2, "()Lcom/tencent/mobileqq/wink/editor/music/viewmodel/c;", "C2", "(Lcom/tencent/mobileqq/wink/editor/music/viewmodel/c;)V", "draftMusicVolume", "com/tencent/mobileqq/wink/editor/music/viewmodel/MusicVolumeControlViewModel$b", "L", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicVolumeControlViewModel$b;", "_bgmLiveData", "M", "T1", "bgmLiveData", "N", "_bgmSliderLiveData", "P", "U1", "bgmSliderLiveData", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "_originVolumeSwitchLiveData", BdhLogUtil.LogTag.Tag_Req, "k2", "originVolumeSwitchLiveData", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/VolumeValueCache;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/VolumeValueCache;", "volumeValueCache", "T", "Z", "t2", "()Z", "J2", "(Z)V", "isOriginalVolumeChangedManually", "U", "r2", NowProxyConstants.AccountInfoKey.A2, "isBgmVolumeChangedManually", "V", "l2", "()Landroidx/lifecycle/MutableLiveData;", "volumeUIChangedLivedData", "<init>", "()V", "W", "a", "VolumeType", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class MusicVolumeControlViewModel extends BaseViewModel {

    /* renamed from: C */
    @NotNull
    private final d _originLiveData;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Float> originLiveData;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private Map<Integer, Float> mediaClipVolumes;

    /* renamed from: F */
    @NotNull
    private Map<Integer, Float> backupMediaClipVolumes;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Float> _originSliderLiveData;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Float> originSliderLiveData;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _originEnabledLiveData;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> originEnabledLiveData;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.wink.editor.music.viewmodel.c draftMusicVolume;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final b _bgmLiveData;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Float> bgmLiveData;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Float> _bgmSliderLiveData;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Float> bgmSliderLiveData;

    /* renamed from: Q */
    @NotNull
    private final MutableLiveData<Boolean> _originVolumeSwitchLiveData;

    /* renamed from: R */
    @NotNull
    private final LiveData<Boolean> originVolumeSwitchLiveData;

    /* renamed from: S */
    @NotNull
    private final VolumeValueCache volumeValueCache;

    /* renamed from: T, reason: from kotlin metadata */
    private boolean isOriginalVolumeChangedManually;

    /* renamed from: U, reason: from kotlin metadata */
    private boolean isBgmVolumeChangedManually;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> volumeUIChangedLivedData;

    /* renamed from: i, reason: from kotlin metadata */
    @NotNull
    private final c _curOperateBgmType;

    /* renamed from: m */
    @NotNull
    private final LiveData<VolumeType> curOperateBgmType;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicVolumeControlViewModel$VolumeType;", "", "(Ljava/lang/String;I)V", "ORIGIN", "BGM", "TEMPLATE", "NONE", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public enum VolumeType {
        ORIGIN,
        BGM,
        TEMPLATE,
        NONE
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/wink/editor/music/viewmodel/MusicVolumeControlViewModel$b", "Landroidx/lifecycle/MediatorLiveData;", "", "value", "", "c", "(Ljava/lang/Float;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b extends MediatorLiveData<Float> {
        b() {
        }

        @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
        /* renamed from: c */
        public void setValue(@Nullable Float value) {
            MusicVolumeControlViewModel.this.C2(null);
            super.setValue(value);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/wink/editor/music/viewmodel/MusicVolumeControlViewModel$c", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicVolumeControlViewModel$VolumeType;", "value", "", "c", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c extends MutableLiveData<VolumeType> {
        c(VolumeType volumeType) {
            super(volumeType);
        }

        @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
        /* renamed from: c */
        public void setValue(@Nullable VolumeType value) {
            MusicVolumeControlViewModel.this.C2(null);
            super.setValue(value);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/wink/editor/music/viewmodel/MusicVolumeControlViewModel$d", "Landroidx/lifecycle/MediatorLiveData;", "", "value", "", "c", "(Ljava/lang/Float;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d extends MediatorLiveData<Float> {
        d() {
        }

        @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
        /* renamed from: c */
        public void setValue(@Nullable Float value) {
            MusicVolumeControlViewModel.this.C2(null);
            super.setValue(value);
        }
    }

    public MusicVolumeControlViewModel() {
        c cVar = new c(VolumeType.NONE);
        this._curOperateBgmType = cVar;
        Intrinsics.checkNotNull(cVar, "null cannot be cast to non-null type androidx.lifecycle.LiveData<com.tencent.mobileqq.wink.editor.music.viewmodel.MusicVolumeControlViewModel.VolumeType>");
        this.curOperateBgmType = cVar;
        d dVar = new d();
        this._originLiveData = dVar;
        Intrinsics.checkNotNull(dVar, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Float>");
        this.originLiveData = dVar;
        this.mediaClipVolumes = new LinkedHashMap();
        this.backupMediaClipVolumes = new LinkedHashMap();
        MutableLiveData<Float> mutableLiveData = new MutableLiveData<>();
        this._originSliderLiveData = mutableLiveData;
        Intrinsics.checkNotNull(mutableLiveData, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Float>");
        this.originSliderLiveData = mutableLiveData;
        MutableLiveData<Boolean> mutableLiveData2 = new MutableLiveData<>();
        this._originEnabledLiveData = mutableLiveData2;
        Intrinsics.checkNotNull(mutableLiveData2, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Boolean>");
        this.originEnabledLiveData = mutableLiveData2;
        b bVar = new b();
        this._bgmLiveData = bVar;
        Intrinsics.checkNotNull(bVar, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Float>");
        this.bgmLiveData = bVar;
        MutableLiveData<Float> mutableLiveData3 = new MutableLiveData<>();
        this._bgmSliderLiveData = mutableLiveData3;
        Intrinsics.checkNotNull(mutableLiveData3, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Float>");
        this.bgmSliderLiveData = mutableLiveData3;
        MutableLiveData<Boolean> mutableLiveData4 = new MutableLiveData<>();
        this._originVolumeSwitchLiveData = mutableLiveData4;
        Intrinsics.checkNotNull(mutableLiveData4, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Boolean>");
        this.originVolumeSwitchLiveData = mutableLiveData4;
        this.volumeValueCache = new VolumeValueCache();
        this.volumeUIChangedLivedData = new MutableLiveData<>();
        final MusicVolumeControlViewModel$1$1 musicVolumeControlViewModel$1$1 = new MusicVolumeControlViewModel$1$1(dVar, this);
        dVar.addSource(mutableLiveData2, new Observer() { // from class: com.tencent.mobileqq.wink.editor.music.viewmodel.y
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MusicVolumeControlViewModel.u2(Function1.this, obj);
            }
        });
        final MusicVolumeControlViewModel$2$1 musicVolumeControlViewModel$2$1 = new MusicVolumeControlViewModel$2$1(bVar, this);
        bVar.addSource(cVar, new Observer() { // from class: com.tencent.mobileqq.wink.editor.music.viewmodel.z
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MusicVolumeControlViewModel.v2(Function1.this, obj);
            }
        });
    }

    private final void B2(boolean enableBgm, boolean isUseTemplate) {
        if (QLog.isDevelopLevel()) {
            w53.b.a("MusicVolumeControlViewModel", "setCurrentBGMStatus enableBgm:" + enableBgm + ", isUseTemplate:" + isUseTemplate);
        }
        this.volumeValueCache.n(enableBgm, isUseTemplate);
    }

    public static final void u2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void v2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static /* synthetic */ void z2(MusicVolumeControlViewModel musicVolumeControlViewModel, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z17 = false;
        }
        musicVolumeControlViewModel.y2(z16, z17);
    }

    public final void A2(boolean z16) {
        this.isBgmVolumeChangedManually = z16;
    }

    public final void C2(@Nullable com.tencent.mobileqq.wink.editor.music.viewmodel.c cVar) {
        this.draftMusicVolume = cVar;
    }

    public final void D2(float f16) {
        w53.b.f("MusicVolumeControlViewModel", "setLastBgmVolume volume:" + f16);
        this.volumeValueCache.o(f16);
    }

    public final void E2(@Nullable Boolean enable) {
        if (enable != null) {
            this.volumeValueCache.q(enable.booleanValue());
        }
    }

    public final void F2(@NotNull Map<Integer, Float> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.mediaClipVolumes = map;
    }

    public final void G2(@NotNull VolumeType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        w53.b.f("MusicVolumeControlViewModel", "setOperateBgmType type:" + type);
        if (this._curOperateBgmType.getValue() != type) {
            this._curOperateBgmType.postValue(type);
        }
    }

    public final void H2(boolean enable) {
        w53.b.f("MusicVolumeControlViewModel", "setOriginEnabled enable:" + enable);
        if (!Intrinsics.areEqual(Boolean.valueOf(enable), this._originEnabledLiveData.getValue())) {
            this._originEnabledLiveData.postValue(Boolean.valueOf(enable));
        }
    }

    public final void I2(boolean enable) {
        if (QLog.isDevelopLevel()) {
            w53.b.a("MusicVolumeControlViewModel", "setOriginVolumeSwitch enable:" + enable);
        }
        if (!Intrinsics.areEqual(Boolean.valueOf(enable), this._originVolumeSwitchLiveData.getValue())) {
            this._originVolumeSwitchLiveData.postValue(Boolean.valueOf(enable));
        }
    }

    public final void J2(boolean z16) {
        this.isOriginalVolumeChangedManually = z16;
    }

    public final void K2(boolean enable) {
        w53.b.f("MusicVolumeControlViewModel", "setTemplateEnabled enable:" + enable);
        if (enable) {
            VolumeType value = this._curOperateBgmType.getValue();
            VolumeType volumeType = VolumeType.TEMPLATE;
            if (value != volumeType) {
                this._curOperateBgmType.postValue(volumeType);
                B2(true, true);
            }
        }
        if (!enable && this._curOperateBgmType.getValue() == VolumeType.TEMPLATE) {
            this._curOperateBgmType.postValue(VolumeType.NONE);
            B2(false, false);
        }
    }

    public final void L2(float r36) {
        w53.b.f("MusicVolumeControlViewModel", "updateBgmVolume volume:" + r36);
        D2(r36);
        S1(r36, VolumeType.BGM);
    }

    public final void M2() {
        this.volumeValueCache.p(this.mediaClipVolumes);
    }

    public final void N2(float r36) {
        w53.b.f("MusicVolumeControlViewModel", "updateOriginVolume volume:" + r36);
        R1(r36);
        M2();
    }

    public final void P1() {
        Map<Integer, Float> mutableMap;
        mutableMap = MapsKt__MapsKt.toMutableMap(this.mediaClipVolumes);
        this.backupMediaClipVolumes = mutableMap;
    }

    public final void Q1(@NotNull Map<Integer, Float> mediaClipVolumes) {
        Map<Integer, Float> mutableMap;
        Intrinsics.checkNotNullParameter(mediaClipVolumes, "mediaClipVolumes");
        if (!mediaClipVolumes.isEmpty()) {
            mutableMap = MapsKt__MapsKt.toMutableMap(mediaClipVolumes);
            this.mediaClipVolumes = mutableMap;
            MutableLiveData<Float> mutableLiveData = this._originSliderLiveData;
            Iterator<T> it = mediaClipVolumes.entrySet().iterator();
            if (it.hasNext()) {
                float floatValue = ((Number) ((Map.Entry) it.next()).getValue()).floatValue();
                while (it.hasNext()) {
                    floatValue = Math.max(floatValue, ((Number) ((Map.Entry) it.next()).getValue()).floatValue());
                }
                mutableLiveData.postValue(Float.valueOf(floatValue));
                return;
            }
            throw new NoSuchElementException();
        }
    }

    public final void R1(float value) {
        float floatValue;
        boolean z16;
        if (this.backupMediaClipVolumes.isEmpty()) {
            floatValue = 0.0f;
        } else {
            Iterator<T> it = this.backupMediaClipVolumes.entrySet().iterator();
            if (it.hasNext()) {
                floatValue = ((Number) ((Map.Entry) it.next()).getValue()).floatValue();
                while (it.hasNext()) {
                    floatValue = Math.max(floatValue, ((Number) ((Map.Entry) it.next()).getValue()).floatValue());
                }
            } else {
                throw new NoSuchElementException();
            }
        }
        if (floatValue == 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            Iterator<Map.Entry<Integer, Float>> it5 = this.mediaClipVolumes.entrySet().iterator();
            while (it5.hasNext()) {
                this.mediaClipVolumes.put(it5.next().getKey(), Float.valueOf(value));
            }
        } else {
            float f16 = value / floatValue;
            for (Map.Entry<Integer, Float> entry : this.backupMediaClipVolumes.entrySet()) {
                if (this.backupMediaClipVolumes.containsKey(entry.getKey())) {
                    Map<Integer, Float> map = this.mediaClipVolumes;
                    Integer key = entry.getKey();
                    Float f17 = this.backupMediaClipVolumes.get(entry.getKey());
                    Intrinsics.checkNotNull(f17);
                    map.put(key, Float.valueOf(f17.floatValue() * f16));
                }
            }
        }
        this._originSliderLiveData.postValue(Float.valueOf(value));
        this.volumeValueCache.m(true);
    }

    public final void S1(float value, @NotNull VolumeType sliderType) {
        Intrinsics.checkNotNullParameter(sliderType, "sliderType");
        w53.b.f("MusicVolumeControlViewModel", "changeVolume sliderType:" + sliderType + ", value:" + value);
        if (sliderType == VolumeType.ORIGIN) {
            w53.b.a("MusicVolumeControlViewModel", "[changeVolume] change origin " + value);
            Iterator<Map.Entry<Integer, Float>> it = this.mediaClipVolumes.entrySet().iterator();
            while (it.hasNext()) {
                this.mediaClipVolumes.put(it.next().getKey(), Float.valueOf(value));
            }
            this._originSliderLiveData.postValue(Float.valueOf(value));
            return;
        }
        w53.b.a("MusicVolumeControlViewModel", "[changeVolume] change bgm " + value);
        this._bgmSliderLiveData.postValue(Float.valueOf(value));
    }

    @NotNull
    public final LiveData<Float> T1() {
        return this.bgmLiveData;
    }

    @NotNull
    public final LiveData<Float> U1() {
        return this.bgmSliderLiveData;
    }

    @NotNull
    public final Pair<Boolean, Boolean> W1() {
        return this.volumeValueCache.b();
    }

    @NotNull
    public final LiveData<VolumeType> X1() {
        return this.curOperateBgmType;
    }

    public final float Z1() {
        if (!s2()) {
            return 0.0f;
        }
        return this.volumeValueCache.f();
    }

    @Nullable
    /* renamed from: a2, reason: from getter */
    public final com.tencent.mobileqq.wink.editor.music.viewmodel.c getDraftMusicVolume() {
        return this.draftMusicVolume;
    }

    public final float b2() {
        if (s2()) {
            if (Intrinsics.areEqual(this._originEnabledLiveData.getValue(), Boolean.FALSE)) {
                return 0.0f;
            }
            return VolumeValueCache.INSTANCE.e();
        }
        return 1.0f;
    }

    public final float c2() {
        return this.volumeValueCache.f();
    }

    @NotNull
    public final Map<Integer, Float> d2() {
        return this.volumeValueCache.g();
    }

    @NotNull
    public final Map<Integer, Float> e2() {
        return this.mediaClipVolumes;
    }

    @NotNull
    public final VolumeType f2() {
        VolumeType value = this._curOperateBgmType.getValue();
        if (value == null) {
            return VolumeType.NONE;
        }
        return value;
    }

    @NotNull
    public final LiveData<Boolean> g2() {
        return this.originEnabledLiveData;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    public String getLogTag() {
        return "MusicVolumeControlViewModel";
    }

    @NotNull
    public final LiveData<Float> h2() {
        return this.originLiveData;
    }

    @NotNull
    public final LiveData<Float> i2() {
        return this.originSliderLiveData;
    }

    public final float j2(@NotNull Map<Integer, Float> mediaClipVolumes) {
        float floatValue;
        boolean z16;
        Intrinsics.checkNotNullParameter(mediaClipVolumes, "mediaClipVolumes");
        if (mediaClipVolumes.isEmpty()) {
            floatValue = 0.0f;
        } else {
            Iterator<T> it = mediaClipVolumes.entrySet().iterator();
            if (it.hasNext()) {
                floatValue = ((Number) ((Map.Entry) it.next()).getValue()).floatValue();
                while (it.hasNext()) {
                    floatValue = Math.max(floatValue, ((Number) ((Map.Entry) it.next()).getValue()).floatValue());
                }
            } else {
                throw new NoSuchElementException();
            }
        }
        if (floatValue == 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            Iterator it5 = VolumeValueCache.e(this.volumeValueCache, false, 1, null).entrySet().iterator();
            if (it5.hasNext()) {
                floatValue = ((Number) ((Map.Entry) it5.next()).getValue()).floatValue();
                while (it5.hasNext()) {
                    floatValue = Math.max(floatValue, ((Number) ((Map.Entry) it5.next()).getValue()).floatValue());
                }
            } else {
                throw new NoSuchElementException();
            }
        }
        return floatValue;
    }

    @NotNull
    public final LiveData<Boolean> k2() {
        return this.originVolumeSwitchLiveData;
    }

    @NotNull
    public final MutableLiveData<Boolean> l2() {
        return this.volumeUIChangedLivedData;
    }

    public final boolean m2() {
        return this.volumeValueCache.getIsChangedManually();
    }

    public final void n2(boolean z16, boolean z17) {
        VolumeValueCache.MusicStatus musicStatus;
        boolean z18;
        if (QLog.isDevelopLevel()) {
            w53.b.a("MusicVolumeControlViewModel", "handleBgmEnableChanged enable:" + z16 + ", isUseTemplate:" + z17);
        }
        if (z16) {
            if (z17) {
                musicStatus = VolumeValueCache.MusicStatus.HasTemplateBGM;
            } else {
                musicStatus = VolumeValueCache.MusicStatus.HasBGM;
            }
        } else {
            musicStatus = VolumeValueCache.MusicStatus.NoBGM;
        }
        if (musicStatus != this.volumeValueCache.getCurrentMusicStatus()) {
            z18 = true;
        } else {
            z18 = false;
        }
        B2(z16, z17);
        if (z18) {
            Q1(d2());
        }
        o2(this.volumeValueCache.h(), z17, false);
    }

    public final void o2(boolean enable, boolean isUseTemplate, boolean fromClick) {
        if (QLog.isDevelopLevel()) {
            w53.b.a("MusicVolumeControlViewModel", "handleOriginEnableChanged enable:" + enable);
        }
        if (enable) {
            this.mediaClipVolumes = d2();
            boolean z16 = true;
            if (!r0.isEmpty()) {
                Iterator<T> it = this.mediaClipVolumes.entrySet().iterator();
                if (it.hasNext()) {
                    float floatValue = ((Number) ((Map.Entry) it.next()).getValue()).floatValue();
                    while (it.hasNext()) {
                        floatValue = Math.max(floatValue, ((Number) ((Map.Entry) it.next()).getValue()).floatValue());
                    }
                    if (floatValue != 0.0f) {
                        z16 = false;
                    }
                    if (z16) {
                        this.mediaClipVolumes = this.volumeValueCache.d(fromClick);
                    }
                    MutableLiveData<Float> mutableLiveData = this._originSliderLiveData;
                    Iterator<T> it5 = this.mediaClipVolumes.entrySet().iterator();
                    if (it5.hasNext()) {
                        float floatValue2 = ((Number) ((Map.Entry) it5.next()).getValue()).floatValue();
                        while (it5.hasNext()) {
                            floatValue2 = Math.max(floatValue2, ((Number) ((Map.Entry) it5.next()).getValue()).floatValue());
                        }
                        mutableLiveData.postValue(Float.valueOf(floatValue2));
                    } else {
                        throw new NoSuchElementException();
                    }
                } else {
                    throw new NoSuchElementException();
                }
            }
        } else {
            Iterator<Map.Entry<Integer, Float>> it6 = this.mediaClipVolumes.entrySet().iterator();
            while (it6.hasNext()) {
                this.mediaClipVolumes.put(it6.next().getKey(), Float.valueOf(0.0f));
            }
            this._originSliderLiveData.postValue(Float.valueOf(0.0f));
        }
        I2(enable);
        E2(Boolean.valueOf(enable));
    }

    public final void p2(@NotNull List<? extends MediaClip> mediaClips) {
        Intrinsics.checkNotNullParameter(mediaClips, "mediaClips");
        this.mediaClipVolumes = com.tencent.videocut.render.extension.e.g(mediaClips);
        this.volumeValueCache.i(mediaClips);
    }

    public final void q2(@NotNull List<? extends MediaClip> mediaClips, @Nullable Boolean isChangedManually) {
        Intrinsics.checkNotNullParameter(mediaClips, "mediaClips");
        if (isChangedManually != null) {
            this.volumeValueCache.m(isChangedManually.booleanValue());
        }
        this.volumeValueCache.i(mediaClips);
    }

    /* renamed from: r2, reason: from getter */
    public final boolean getIsBgmVolumeChangedManually() {
        return this.isBgmVolumeChangedManually;
    }

    public final boolean s2() {
        return this.volumeValueCache.k();
    }

    /* renamed from: t2, reason: from getter */
    public final boolean getIsOriginalVolumeChangedManually() {
        return this.isOriginalVolumeChangedManually;
    }

    public final void w2(@Nullable Pair<Boolean, Boolean> pair) {
        if (pair != null) {
            this.volumeValueCache.l(pair);
        }
    }

    public final void x2(boolean isChangedManually) {
        this.volumeValueCache.m(isChangedManually);
    }

    public final void y2(boolean enable, boolean forceClose) {
        if (QLog.isDevelopLevel()) {
            w53.b.a("MusicVolumeControlViewModel", "setBgmEnabled enable:" + enable + ", forceClose:" + forceClose);
        }
        if (enable) {
            VolumeType value = this._curOperateBgmType.getValue();
            VolumeType volumeType = VolumeType.BGM;
            if (value != volumeType) {
                this._curOperateBgmType.postValue(volumeType);
                B2(true, false);
                return;
            }
        }
        if ((!enable && this._curOperateBgmType.getValue() != VolumeType.TEMPLATE) || (forceClose && !enable)) {
            this._curOperateBgmType.postValue(VolumeType.NONE);
            B2(false, false);
        }
    }
}
