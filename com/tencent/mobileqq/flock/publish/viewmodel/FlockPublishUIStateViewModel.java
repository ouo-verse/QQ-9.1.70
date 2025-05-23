package com.tencent.mobileqq.flock.publish.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.arch.core.util.Function;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.flock.repeat.FlockRepeatType;
import com.tencent.mobileqq.flock.utils.DateTimeUtils;
import com.tencent.mobileqq.flock.widget.g;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qqnt.kernel.nativeinterface.WiFiPhotoErrorCode;
import com.tencent.qzonehub.api.IQzonePluginProxyActivity;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.util.QQToastUtil;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.QZoneHelper;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\"\u0018\u0000 ~2\u00020\u0001:\u0001\u007fB\u000f\u0012\u0006\u0010{\u001a\u00020!\u00a2\u0006\u0004\b|\u0010}J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u001e\u0010\n\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J\u0012\u0010\r\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0010\u001a\u00020\u000eJ\u0014\u0010\u0011\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u000e\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012J\u0010\u0010\u0016\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010\u0018\u001a\u00020\u0017J\u0006\u0010\u0019\u001a\u00020\u0012J\b\u0010\u001a\u001a\u0004\u0018\u00010\u000bJ\b\u0010\u001b\u001a\u0004\u0018\u00010\u000bJ\u0014\u0010\u001c\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u0006\u0010\u001d\u001a\u00020\u0002J\u000e\u0010 \u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001eJ\u0010\u0010#\u001a\u00020\u00022\b\u0010\"\u001a\u0004\u0018\u00010!J\u000e\u0010%\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\bJ\u0006\u0010&\u001a\u00020\bJ\u0006\u0010'\u001a\u00020\bJ\u0006\u0010)\u001a\u00020(J\b\u0010*\u001a\u00020\u0017H\u0016J\u0010\u0010-\u001a\u00020\u00022\b\u0010,\u001a\u0004\u0018\u00010+R\u001d\u00102\u001a\u0004\u0018\u00010\u00178FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u001d\u00105\u001a\u0004\u0018\u00010\u00178FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b3\u0010/\u001a\u0004\b4\u00101R*\u0010<\u001a\u00020\u00172\u0006\u00106\u001a\u00020\u00178\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u00101\"\u0004\b:\u0010;R\"\u0010@\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u00108\u001a\u0004\b>\u00101\"\u0004\b?\u0010;R#\u0010D\u001a\n A*\u0004\u0018\u00010\u00170\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bB\u0010/\u001a\u0004\bC\u00101R\u001c\u0010H\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u001f\u0010N\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120I8\u0006\u00a2\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010MR\u001c\u0010P\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010GR\u001f\u0010S\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0I8\u0006\u00a2\u0006\f\n\u0004\bQ\u0010K\u001a\u0004\bR\u0010MR\u001c\u0010V\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010T0E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bU\u0010GR\u001d\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00170I8\u0006\u00a2\u0006\f\n\u0004\bW\u0010K\u001a\u0004\bX\u0010MR\u0016\u0010]\u001a\u00020Z8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0014\u0010a\u001a\u00020^8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b_\u0010`R\u0014\u0010c\u001a\u00020^8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bb\u0010`R\u001a\u0010e\u001a\b\u0012\u0004\u0012\u00020\u000b0E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bd\u0010GR\u001d\u0010h\u001a\b\u0012\u0004\u0012\u00020\u00170I8\u0006\u00a2\u0006\f\n\u0004\bf\u0010K\u001a\u0004\bg\u0010MR\u001c\u0010j\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bi\u0010GR\u001d\u0010m\u001a\b\u0012\u0004\u0012\u00020\u00170I8\u0006\u00a2\u0006\f\n\u0004\bk\u0010K\u001a\u0004\bl\u0010MR\"\u0010o\u001a\u0010\u0012\f\u0012\n A*\u0004\u0018\u00010\b0\b0E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bn\u0010GR\u001d\u0010r\u001a\b\u0012\u0004\u0012\u00020\b0I8\u0006\u00a2\u0006\f\n\u0004\bp\u0010K\u001a\u0004\bq\u0010MR\u001d\u0010u\u001a\b\u0012\u0004\u0012\u00020\b0I8\u0006\u00a2\u0006\f\n\u0004\bs\u0010K\u001a\u0004\bt\u0010MR\u001c\u0010w\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010+0E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bv\u0010GR\u001f\u0010z\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010+0I8\u0006\u00a2\u0006\f\n\u0004\bx\u0010K\u001a\u0004\by\u0010M\u00a8\u0006\u0080\u0001"}, d2 = {"Lcom/tencent/mobileqq/flock/publish/viewmodel/FlockPublishUIStateViewModel;", "Lcom/tencent/mobileqq/flock/publish/viewmodel/FlockPublishBaseViewModel;", "", "o2", "p2", "", "", "selectItems", "", "resetEndTime", NowProxyConstants.AccountInfoKey.A2, "Ljava/util/Date;", "endTime", "q2", "Lcom/tencent/mobileqq/flock/widget/g$d;", "m2", "Z1", "z2", "Lcom/tencent/mobileqq/flock/repeat/FlockRepeatType;", "type", "y2", "date", "x2", "", "g2", "k2", "i2", "W1", "w2", "v2", "Landroid/content/Context;", "context", ICustomDataEditor.STRING_PARAM_2, "Landroid/content/Intent;", "data", "u2", "isChecked", "C2", "r2", "S1", "Ly45/b;", "f2", "getLogTag", "Lb55/g;", "tagInfo", "E2", "E", "Lkotlin/Lazy;", "b2", "()Ljava/lang/String;", "feedTitle", UserInfo.SEX_FEMALE, ICustomDataEditor.STRING_ARRAY_PARAM_2, "feedContent", "value", "G", "Ljava/lang/String;", "getTitle", Constants.BASE_IN_PLUGIN_VERSION, "(Ljava/lang/String;)V", "title", "H", "getContent", "B2", "content", "kotlin.jvm.PlatformType", "I", "U1", "accountUin", "Landroidx/lifecycle/MutableLiveData;", "J", "Landroidx/lifecycle/MutableLiveData;", "_repeatType", "Landroidx/lifecycle/LiveData;", "K", "Landroidx/lifecycle/LiveData;", "j2", "()Landroidx/lifecycle/LiveData;", "repeatType", "L", "_repeatEndTime", "M", SemanticAttributes.DbSystemValues.H2, "repeatEndTime", "Lcooperation/qzone/LbsDataV2$PoiInfo;", "N", "_selectPoiData", "P", "c2", "locationName", "Lcom/tencent/mobileqq/flock/publish/viewmodel/a;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/flock/publish/viewmodel/a;", "timeRepository", "Ljava/text/SimpleDateFormat;", BdhLogUtil.LogTag.Tag_Req, "Ljava/text/SimpleDateFormat;", "timeDisplayFormat", ExifInterface.LATITUDE_SOUTH, "repeatEndTimeDisplayFormat", "T", "_startSelectTime", "U", "l2", "startSelectTime", "V", "_endSelectTime", "W", "X1", "endSelectTime", "X", "_publicRightEnable", "Y", "d2", "publicRightEnable", "Z", "e2", "publishBtnEnable", "a0", "_topicInfo", "b0", ICustomDataEditor.NUMBER_PARAM_2, "topicInfo", "intent", "<init>", "(Landroid/content/Intent;)V", "c0", "a", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FlockPublishUIStateViewModel extends FlockPublishBaseViewModel {
    static IPatchRedirector $redirector_;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy feedTitle;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy feedContent;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private String title;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private String content;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy accountUin;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<FlockRepeatType> _repeatType;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final LiveData<FlockRepeatType> repeatType;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Date> _repeatEndTime;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Date> repeatEndTime;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<LbsDataV2.PoiInfo> _selectPoiData;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final LiveData<String> locationName;

    /* renamed from: Q, reason: from kotlin metadata */
    private a timeRepository;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final SimpleDateFormat timeDisplayFormat;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final SimpleDateFormat repeatEndTimeDisplayFormat;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Date> _startSelectTime;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final LiveData<String> startSelectTime;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Date> _endSelectTime;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private final LiveData<String> endSelectTime;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _publicRightEnable;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> publicRightEnable;

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> publishBtnEnable;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<b55.g> _topicInfo;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveData<b55.g> topicInfo;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/flock/publish/viewmodel/FlockPublishUIStateViewModel$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.flock.publish.viewmodel.FlockPublishUIStateViewModel$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48535);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 35)) {
            redirector.redirect((short) 35);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlockPublishUIStateViewModel(@NotNull Intent intent) {
        super(intent);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        y45.f[] fVarArr;
        Object orNull;
        b55.g b16;
        y45.l lVar;
        LbsDataV2.PoiInfo a16;
        Intrinsics.checkNotNullParameter(intent, "intent");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.flock.publish.viewmodel.FlockPublishUIStateViewModel$feedTitle$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlockPublishUIStateViewModel.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final String invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    y45.b M1 = FlockPublishUIStateViewModel.this.M1();
                    if (M1 != null) {
                        return M1.f449371f;
                    }
                    return null;
                }
            });
            this.feedTitle = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.flock.publish.viewmodel.FlockPublishUIStateViewModel$feedContent$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlockPublishUIStateViewModel.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final String invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    y45.b M1 = FlockPublishUIStateViewModel.this.M1();
                    if (M1 != null) {
                        return com.tencent.mobileqq.flock.ktx.e.a(M1);
                    }
                    return null;
                }
            });
            this.feedContent = lazy2;
            this.title = "";
            this.content = "";
            lazy3 = LazyKt__LazyJVMKt.lazy(FlockPublishUIStateViewModel$accountUin$2.INSTANCE);
            this.accountUin = lazy3;
            MutableLiveData<FlockRepeatType> mutableLiveData = new MutableLiveData<>();
            this._repeatType = mutableLiveData;
            this.repeatType = mutableLiveData;
            MutableLiveData<Date> mutableLiveData2 = new MutableLiveData<>();
            this._repeatEndTime = mutableLiveData2;
            this.repeatEndTime = mutableLiveData2;
            MutableLiveData<LbsDataV2.PoiInfo> mutableLiveData3 = new MutableLiveData<>();
            this._selectPoiData = mutableLiveData3;
            LiveData<String> map = Transformations.map(mutableLiveData3, new Function() { // from class: com.tencent.mobileqq.flock.publish.viewmodel.g
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    String t26;
                    t26 = FlockPublishUIStateViewModel.t2((LbsDataV2.PoiInfo) obj);
                    return t26;
                }
            });
            Intrinsics.checkNotNullExpressionValue(map, "map(_selectPoiData) { it?.poiName ?: \"\" }");
            this.locationName = map;
            this.timeDisplayFormat = new SimpleDateFormat("MM\u6708dd\u65e5 HH:mm", Locale.CHINA);
            this.repeatEndTimeDisplayFormat = new SimpleDateFormat("MM\u6708dd\u65e5", Locale.CHINA);
            MutableLiveData<Date> mutableLiveData4 = new MutableLiveData<>();
            this._startSelectTime = mutableLiveData4;
            LiveData<String> map2 = Transformations.map(mutableLiveData4, new Function() { // from class: com.tencent.mobileqq.flock.publish.viewmodel.h
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    String F2;
                    F2 = FlockPublishUIStateViewModel.F2(FlockPublishUIStateViewModel.this, (Date) obj);
                    return F2;
                }
            });
            Intrinsics.checkNotNullExpressionValue(map2, "map(_startSelectTime) { \u2026isplayFormat.format(it) }");
            this.startSelectTime = map2;
            MutableLiveData<Date> mutableLiveData5 = new MutableLiveData<>();
            this._endSelectTime = mutableLiveData5;
            LiveData<String> map3 = Transformations.map(mutableLiveData5, new Function() { // from class: com.tencent.mobileqq.flock.publish.viewmodel.i
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    String T1;
                    T1 = FlockPublishUIStateViewModel.T1(FlockPublishUIStateViewModel.this, (Date) obj);
                    return T1;
                }
            });
            Intrinsics.checkNotNullExpressionValue(map3, "map(_endSelectTime) {\n  \u2026.format(it) } ?: \"\"\n    }");
            this.endSelectTime = map3;
            Boolean bool = Boolean.FALSE;
            MutableLiveData<Boolean> mutableLiveData6 = new MutableLiveData<>(bool);
            this._publicRightEnable = mutableLiveData6;
            this.publicRightEnable = mutableLiveData6;
            this.publishBtnEnable = new MutableLiveData(bool);
            MutableLiveData<b55.g> mutableLiveData7 = new MutableLiveData<>();
            this._topicInfo = mutableLiveData7;
            this.topicInfo = mutableLiveData7;
            o2();
            y45.b M1 = M1();
            if (M1 != null && (lVar = M1.f449376k) != null && (a16 = com.tencent.mobileqq.flock.ktx.f.a(lVar)) != null) {
                mutableLiveData3.postValue(a16);
            }
            p2();
            y45.b M12 = M1();
            if (M12 != null && (fVarArr = M12.f449383r) != null) {
                orNull = ArraysKt___ArraysKt.getOrNull(fVarArr, 0);
                y45.f fVar = (y45.f) orNull;
                if (fVar != null && (b16 = com.tencent.mobileqq.flock.ktx.h.b(fVar)) != null) {
                    mutableLiveData7.postValue(b16);
                }
            }
            b55.g O1 = O1();
            if (O1 != null) {
                mutableLiveData7.postValue(O1);
                return;
            }
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) intent);
    }

    private final void A2(List<Integer> selectItems, boolean resetEndTime) {
        MutableLiveData<Date> mutableLiveData = this._startSelectTime;
        a aVar = this.timeRepository;
        a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timeRepository");
            aVar = null;
        }
        mutableLiveData.setValue(aVar.k(selectItems));
        if (resetEndTime) {
            if (this._endSelectTime.getValue() == null || !q2(this._endSelectTime.getValue())) {
                a aVar3 = this.timeRepository;
                if (aVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("timeRepository");
                } else {
                    aVar2 = aVar3;
                }
                aVar2.i();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String F2(FlockPublishUIStateViewModel this$0, Date date) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return this$0.timeDisplayFormat.format(date);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String T1(FlockPublishUIStateViewModel this$0, Date date) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (date != null) {
            str = this$0.timeDisplayFormat.format(date);
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    private final String U1() {
        return (String) this.accountUin.getValue();
    }

    private final void o2() {
        y45.a aVar;
        Long l3;
        Long l16;
        long j3;
        long j16;
        y45.b M1 = M1();
        a aVar2 = null;
        if (M1 != null) {
            aVar = M1.f449374i;
        } else {
            aVar = null;
        }
        if (aVar != null) {
            l3 = Long.valueOf(aVar.f449361a * 1000);
        } else {
            l3 = null;
        }
        if (aVar != null) {
            l16 = Long.valueOf(aVar.f449362b * 1000);
        } else {
            l16 = null;
        }
        a aVar3 = new a(l3, l16);
        this.timeRepository = aVar3;
        if (aVar != null) {
            j3 = aVar.f449361a;
        } else {
            j3 = 0;
        }
        int i3 = 0;
        if (j3 != 0) {
            A2(aVar3.e(), false);
        }
        if (aVar != null) {
            j16 = aVar.f449362b;
        } else {
            j16 = 0;
        }
        if (j16 != 0) {
            a aVar4 = this.timeRepository;
            if (aVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("timeRepository");
            } else {
                aVar2 = aVar4;
            }
            w2(aVar2.b());
        }
        FlockRepeatType.Companion companion = FlockRepeatType.INSTANCE;
        if (aVar != null) {
            i3 = aVar.f449363c;
        }
        y2(companion.b(i3));
        if (aVar != null) {
            long j17 = aVar.f449364d;
            if (j17 != 0) {
                x2(new Date(j17 * 1000));
            }
        }
    }

    private final void p2() {
        boolean z16;
        int i3;
        boolean z17;
        y45.e eVar;
        boolean z18 = false;
        if (N1() != 2 && N1() != 3) {
            z16 = false;
        } else {
            z16 = true;
        }
        y45.b M1 = M1();
        if (M1 != null && (eVar = M1.f449377l) != null) {
            i3 = eVar.f449389a;
        } else {
            i3 = 1;
        }
        if (i3 == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        MutableLiveData<Boolean> mutableLiveData = this._publicRightEnable;
        if (z16 || z17) {
            z18 = true;
        }
        mutableLiveData.setValue(Boolean.valueOf(z18));
    }

    private final boolean q2(Date endTime) {
        boolean z16;
        if (endTime == null) {
            return true;
        }
        Date value = this._startSelectTime.getValue();
        if (value != null && value.before(endTime)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String t2(LbsDataV2.PoiInfo poiInfo) {
        String str;
        if (poiInfo != null) {
            str = poiInfo.poiName;
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public final void B2(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.content = str;
        }
    }

    public final void C2(boolean isChecked) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, isChecked);
        } else {
            this._publicRightEnable.postValue(Boolean.valueOf(isChecked));
        }
    }

    public final void D2(@NotNull String value) {
        boolean isBlank;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) value);
            return;
        }
        Intrinsics.checkNotNullParameter(value, "value");
        this.title = value;
        LiveData<Boolean> liveData = this.publishBtnEnable;
        Intrinsics.checkNotNull(liveData, "null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<kotlin.Boolean>");
        isBlank = StringsKt__StringsJVMKt.isBlank(value);
        ((MutableLiveData) liveData).setValue(Boolean.valueOf(!isBlank));
    }

    public final void E2(@Nullable b55.g tagInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) tagInfo);
        } else {
            this._topicInfo.postValue(tagInfo);
        }
    }

    public final boolean S1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Boolean) iPatchRedirector.redirect((short) 31, (Object) this)).booleanValue();
        }
        if (q2(this._endSelectTime.getValue())) {
            return true;
        }
        QQToastUtil.showQQToast(1, "\u5f00\u59cb\u65f6\u95f4\u4e0d\u53ef\u665a\u4e8e\u7ed3\u675f\u65f6\u95f4");
        return false;
    }

    @Nullable
    public final Date W1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (Date) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        return this._startSelectTime.getValue();
    }

    @NotNull
    public final LiveData<String> X1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (LiveData) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.endSelectTime;
    }

    @NotNull
    public final g.d Z1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (g.d) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        a aVar = this.timeRepository;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timeRepository");
            aVar = null;
        }
        return aVar.c();
    }

    @Nullable
    public final String a2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return (String) this.feedContent.getValue();
    }

    @Nullable
    public final String b2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return (String) this.feedTitle.getValue();
    }

    @NotNull
    public final LiveData<String> c2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (LiveData) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.locationName;
    }

    @NotNull
    public final LiveData<Boolean> d2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (LiveData) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.publicRightEnable;
    }

    @NotNull
    public final LiveData<Boolean> e2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (LiveData) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.publishBtnEnable;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00b4  */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final y45.b f2() {
        Unit unit;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (y45.b) iPatchRedirector.redirect((short) 32, (Object) this);
        }
        y45.b M1 = M1();
        if (M1 == null) {
            M1 = new y45.b();
        }
        M1.f449371f = this.title;
        M1.f449372g = this.content;
        y45.a aVar = new y45.a();
        aVar.f449361a = com.tencent.mobileqq.flock.ktx.b.b(this._startSelectTime.getValue());
        aVar.f449362b = com.tencent.mobileqq.flock.ktx.b.b(this._endSelectTime.getValue());
        aVar.f449363c = FlockRepeatType.INSTANCE.a(k2());
        aVar.f449364d = com.tencent.mobileqq.flock.ktx.b.b(this._repeatEndTime.getValue());
        M1.f449374i = aVar;
        LbsDataV2.PoiInfo it = this._selectPoiData.getValue();
        if (it != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            M1.f449376k = com.tencent.mobileqq.flock.ktx.f.b(it);
        }
        y45.e eVar = new y45.e();
        eVar.f449389a = !Intrinsics.areEqual(this._publicRightEnable.getValue(), Boolean.TRUE) ? 1 : 0;
        M1.f449377l = eVar;
        b55.g value = this.topicInfo.getValue();
        if (value != null) {
            Intrinsics.checkNotNullExpressionValue(value, "value");
            y45.f a16 = com.tencent.mobileqq.flock.ktx.h.a(value);
            if (a16 != null) {
                M1.f449383r = new y45.f[]{a16};
                unit = Unit.INSTANCE;
                if (unit == null) {
                    M1.f449383r = null;
                }
                return M1;
            }
        }
        unit = null;
        if (unit == null) {
        }
        return M1;
    }

    @NotNull
    public final String g2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return DateTimeUtils.f210478a.g(k2(), W1(), i2(), false);
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return (String) iPatchRedirector.redirect((short) 33, (Object) this);
        }
        return "FlockPublishUIStateViewModel";
    }

    @NotNull
    public final LiveData<Date> h2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (LiveData) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.repeatEndTime;
    }

    @Nullable
    public final Date i2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (Date) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return this._repeatEndTime.getValue();
    }

    @NotNull
    public final LiveData<FlockRepeatType> j2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (LiveData) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.repeatType;
    }

    @NotNull
    public final FlockRepeatType k2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (FlockRepeatType) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        FlockRepeatType value = this._repeatType.getValue();
        if (value == null) {
            value = FlockRepeatType.NONE;
        }
        Intrinsics.checkNotNullExpressionValue(value, "_repeatType.value ?: FlockRepeatType.NONE");
        return value;
    }

    @NotNull
    public final LiveData<String> l2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (LiveData) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.startSelectTime;
    }

    @NotNull
    public final g.d m2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (g.d) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        a aVar = this.timeRepository;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timeRepository");
            aVar = null;
        }
        return aVar.f();
    }

    @NotNull
    public final LiveData<b55.g> n2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (LiveData) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.topicInfo;
    }

    public final boolean r2() {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Boolean) iPatchRedirector.redirect((short) 30, (Object) this)).booleanValue();
        }
        if (this.title.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return true;
        }
        if (this.content.length() > 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17 || this._selectPoiData.getValue() != null || this._startSelectTime.getValue() != null || this._endSelectTime.getValue() != null || Intrinsics.areEqual(this.publicRightEnable.getValue(), Boolean.TRUE)) {
            return true;
        }
        return false;
    }

    public final void s2(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Bundle bundle = new Bundle();
        bundle.putInt("key_lbs_state", 0);
        LbsDataV2.PoiInfo value = this._selectPoiData.getValue();
        if (value != null) {
            bundle.putInt("key_lbs_state", 1);
            bundle.putParcelable("key_current_poi", value);
        }
        bundle.putBoolean("key_sync_weishi", false);
        bundle.putBoolean("key_show_local_geo", false);
        bundle.putInt("key_app_id", WiFiPhotoErrorCode.ERR_FILEBRIDGE_NOT_FOLDER);
        bundle.putBoolean("key_is_test_case", true);
        bundle.putBoolean("key_not_adapt_night_mode", true);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).setActivityNameToIntent(intent, QZoneHelper.MOOD_SELECT_LOCATION);
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(context, U1(), intent, 1208);
    }

    public final void u2(@Nullable Intent data) {
        LbsDataV2.PoiInfo poiInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) data);
            return;
        }
        LbsDataV2.PoiInfo poiInfo2 = null;
        if (data != null) {
            poiInfo = (LbsDataV2.PoiInfo) data.getParcelableExtra(QZoneHelper.INDEX_MOOD_SELECT_LOCATION_ITEM_SELECT_POI);
        } else {
            poiInfo = null;
        }
        if (poiInfo != null && !Intrinsics.areEqual(poiInfo.poiId, "invalide_poi_id")) {
            poiInfo2 = poiInfo;
        }
        this._selectPoiData.postValue(poiInfo2);
    }

    public final void v2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
            return;
        }
        a aVar = this.timeRepository;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timeRepository");
            aVar = null;
        }
        aVar.i();
        this._endSelectTime.setValue(null);
    }

    public final boolean w2(@NotNull List<Integer> selectItems) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this, (Object) selectItems)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(selectItems, "selectItems");
        a aVar = this.timeRepository;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timeRepository");
            aVar = null;
        }
        Date j3 = aVar.j(selectItems);
        if (q2(j3)) {
            this._endSelectTime.setValue(j3);
            return true;
        }
        return false;
    }

    public final void x2(@Nullable Date date) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) date);
        } else {
            this._repeatEndTime.setValue(date);
        }
    }

    public final void y2(@NotNull FlockRepeatType type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) type);
        } else {
            Intrinsics.checkNotNullParameter(type, "type");
            this._repeatType.setValue(type);
        }
    }

    public final void z2(@NotNull List<Integer> selectItems) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) selectItems);
        } else {
            Intrinsics.checkNotNullParameter(selectItems, "selectItems");
            A2(selectItems, true);
        }
    }
}
