package com.qzone.reborn.part.publish.mood.imageai;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.google.gson.Gson;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.bl;
import com.tencent.mobileqq.wink.api.IWinkAIApi;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsKt;
import qshadow.QZoneAutoTexting$TextInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010%\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0007\u0018\u0000 >2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001?B\u0007\u00a2\u0006\u0004\b<\u0010=J0\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u0016\u0010\u000f\u001a\u00020\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0002J\b\u0010\u0012\u001a\u00020\u0007H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016J/\u0010\u0017\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u000e\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007J\u000e\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007J\u000e\u0010\u001b\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nJ\u0010\u0010\u001d\u001a\u00020\f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0007J\u0006\u0010\u001e\u001a\u00020\fJ\u0012\u0010\u001f\u001a\u00020\f2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0007R.\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010.\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R.\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0/8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0018\u00108\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u0010)R\u0016\u0010;\u001a\u0002098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010:\u00a8\u0006@"}, d2 = {"Lcom/qzone/reborn/part/publish/mood/imageai/l;", "Lql/a;", "", "", "isSuccess", "", "retCode", "", "errorMsg", "", "Lqshadow/QZoneAutoTexting$TextInfo;", "textInfo", "", "b2", "textInfos", "f2", "inputContent", "W1", "getLogTag", "M1", "imagePath", "isRetry", "originText", "d2", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V", "X1", ICustomDataEditor.STRING_ARRAY_PARAM_2, SemanticAttributes.DbSystemValues.H2, "firstImagePath", "c2", "R1", "S1", "Landroidx/lifecycle/MutableLiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "U1", "()Landroidx/lifecycle/MutableLiveData;", "setAiTextInfoLiveData", "(Landroidx/lifecycle/MutableLiveData;)V", "aiTextInfoLiveData", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "Z1", "()Ljava/lang/String;", "setCurrentImagePath", "(Ljava/lang/String;)V", "currentImagePath", "", "D", "Ljava/util/Map;", "getSelectAiTextInfoMap", "()Ljava/util/Map;", "setSelectAiTextInfoMap", "(Ljava/util/Map;)V", "selectAiTextInfoMap", "E", "aiTextUseJsonStr", "", UserInfo.SEX_FEMALE, "aiTextUseRate", "<init>", "()V", "G", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class l extends ql.a<Object> {

    /* renamed from: C, reason: from kotlin metadata */
    private String currentImagePath;

    /* renamed from: E, reason: from kotlin metadata */
    private String aiTextUseJsonStr;

    /* renamed from: F, reason: from kotlin metadata */
    private float aiTextUseRate;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private MutableLiveData<List<QZoneAutoTexting$TextInfo>> aiTextInfoLiveData = new MutableLiveData<>();

    /* renamed from: D, reason: from kotlin metadata */
    private Map<String, QZoneAutoTexting$TextInfo> selectAiTextInfoMap = new LinkedHashMap();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J0\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"com/qzone/reborn/part/publish/mood/imageai/l$b", "Lcom/tencent/mobileqq/wink/api/e;", "", "Lqshadow/QZoneAutoTexting$TextInfo;", "textInfo", "", "a", "", "isSuccess", "", "retCode", "", "errorMsg", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements com.tencent.mobileqq.wink.api.e {
        b() {
        }

        @Override // com.tencent.mobileqq.wink.api.e
        public void a(List<QZoneAutoTexting$TextInfo> textInfo) {
            Intrinsics.checkNotNullParameter(textInfo, "textInfo");
            QLog.i("QZonePublishPicToTextViewModel", 1, "[onImageTextGenerating] textInfo\uff1a" + textInfo);
            l.this.f2(textInfo);
        }

        @Override // com.tencent.mobileqq.wink.api.e
        public void b(boolean isSuccess, long retCode, String errorMsg, List<QZoneAutoTexting$TextInfo> textInfo) {
            Intrinsics.checkNotNullParameter(textInfo, "textInfo");
            l.this.b2(isSuccess, retCode, errorMsg, textInfo);
        }
    }

    private final String W1(String inputContent) {
        boolean contains$default;
        if (bl.b(this.aiTextInfoLiveData.getValue())) {
            QLog.e("QZonePublishPicToTextViewModel", 1, "[getAiTextJsonStr] aiTextInfo is empty");
            return "";
        }
        try {
            this.aiTextUseRate = 0.0f;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            List<QZoneAutoTexting$TextInfo> value = this.aiTextInfoLiveData.getValue();
            Intrinsics.checkNotNull(value);
            for (QZoneAutoTexting$TextInfo qZoneAutoTexting$TextInfo : value) {
                if (!TextUtils.isEmpty(qZoneAutoTexting$TextInfo.content.get())) {
                    String str = "0";
                    if (this.selectAiTextInfoMap.containsValue(qZoneAutoTexting$TextInfo)) {
                        String str2 = qZoneAutoTexting$TextInfo.content.get();
                        Intrinsics.checkNotNullExpressionValue(str2, "entry.content.get()");
                        contains$default = StringsKt__StringsKt.contains$default((CharSequence) inputContent, (CharSequence) str2, false, 2, (Object) null);
                        if (contains$default) {
                            str = "1";
                            this.aiTextUseRate = Math.max(1.0f, this.aiTextUseRate);
                        } else {
                            f fVar = f.f58673a;
                            String str3 = qZoneAutoTexting$TextInfo.content.get();
                            Intrinsics.checkNotNullExpressionValue(str3, "entry.content.get()");
                            float a16 = fVar.a(inputContent, str3);
                            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                            String format = String.format("%.4f", Arrays.copyOf(new Object[]{Float.valueOf(a16)}, 1));
                            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                            this.aiTextUseRate = Math.max(a16, this.aiTextUseRate);
                            str = "2," + format;
                        }
                    }
                    String str4 = qZoneAutoTexting$TextInfo.f429485id.get();
                    Intrinsics.checkNotNullExpressionValue(str4, "entry.id.get()");
                    linkedHashMap.put(str4, str);
                }
            }
            QLog.i("QZonePublishPicToTextViewModel", 1, "[getAiTextJsonStr]  | textContent:" + inputContent + " | resultMap" + linkedHashMap + " | selectAiTextInfoMap:" + this.selectAiTextInfoMap + " | aiTextUseRate:" + this.aiTextUseRate);
            return new Gson().toJson(linkedHashMap);
        } catch (Exception e16) {
            QLog.e("QZonePublishPicToTextViewModel", 1, "[getAiTextJsonStr] fail:" + e16);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b2(boolean isSuccess, long retCode, String errorMsg, List<QZoneAutoTexting$TextInfo> textInfo) {
        QLog.i("QZonePublishPicToTextViewModel", 1, "[handleImageTextFinished] | isSuccess: " + isSuccess + " | retCode: " + retCode + " | errorMsg: " + errorMsg);
        f2(textInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f2(final List<QZoneAutoTexting$TextInfo> textInfos) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.reborn.part.publish.mood.imageai.k
            @Override // java.lang.Runnable
            public final void run() {
                l.g2(l.this, textInfos);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g2(l this$0, List textInfos) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(textInfos, "$textInfos");
        this$0.aiTextInfoLiveData.setValue(textInfos);
    }

    @Override // ql.a
    public boolean M1() {
        return false;
    }

    public final void R1() {
        if (TextUtils.isEmpty(this.currentImagePath)) {
            QLog.e("QZonePublishPicToTextViewModel", 1, "[cancelImageText] image path is null");
            return;
        }
        IWinkAIApi iWinkAIApi = (IWinkAIApi) QRoute.api(IWinkAIApi.class);
        String str = this.currentImagePath;
        Intrinsics.checkNotNull(str);
        iWinkAIApi.cancelImageText(str);
    }

    public final void S1(String imagePath) {
        QLog.i("QZonePublishPicToTextViewModel", 1, "[clearCache] image path: " + imagePath);
        ((IWinkAIApi) QRoute.api(IWinkAIApi.class)).clearCache(imagePath);
    }

    public final MutableLiveData<List<QZoneAutoTexting$TextInfo>> U1() {
        return this.aiTextInfoLiveData;
    }

    public final String X1(String inputContent) {
        Intrinsics.checkNotNullParameter(inputContent, "inputContent");
        if (this.aiTextUseJsonStr == null) {
            this.aiTextUseJsonStr = W1(inputContent);
        }
        float V0 = com.qzone.reborn.configx.g.f53821a.b().V0();
        QLog.i("QZonePublishPicToTextViewModel", 1, "[getAiTextUseRate] rate =" + this.aiTextUseRate + ", config=" + V0);
        if (this.aiTextUseRate >= V0) {
            return "use_ai_text";
        }
        return "";
    }

    /* renamed from: Z1, reason: from getter */
    public final String getCurrentImagePath() {
        return this.currentImagePath;
    }

    public final String a2(String inputContent) {
        Intrinsics.checkNotNullParameter(inputContent, "inputContent");
        if (this.aiTextUseJsonStr == null) {
            this.aiTextUseJsonStr = W1(inputContent);
        }
        String str = this.aiTextUseJsonStr;
        return str == null ? "" : str;
    }

    public final void c2(String firstImagePath) {
        if (TextUtils.isEmpty(this.currentImagePath)) {
            QLog.e("QZonePublishPicToTextViewModel", 1, "[onChangeSelectFirstImage] currentImagePath is null ");
            return;
        }
        if (Intrinsics.areEqual(this.currentImagePath, firstImagePath)) {
            QLog.e("QZonePublishPicToTextViewModel", 1, "[onChangeSelectFirstImage] selected same image");
            return;
        }
        QLog.i("QZonePublishPicToTextViewModel", 1, "[onChangeSelectFirstImage] change selected image");
        R1();
        S1(this.currentImagePath);
        this.selectAiTextInfoMap.clear();
    }

    public final void d2(String imagePath, Boolean isRetry, String originText) {
        boolean areEqual = Intrinsics.areEqual(this.currentImagePath, imagePath);
        if (Intrinsics.areEqual(isRetry, Boolean.TRUE)) {
            areEqual = false;
        }
        QLog.i("QZonePublishPicToTextViewModel", 1, "[requestImageText] imagePath:" + imagePath + ", useCache:" + areEqual);
        if (TextUtils.isEmpty(imagePath)) {
            return;
        }
        this.currentImagePath = imagePath;
        IWinkAIApi iWinkAIApi = (IWinkAIApi) QRoute.api(IWinkAIApi.class);
        Intrinsics.checkNotNull(imagePath);
        if (originText == null) {
            originText = "";
        }
        iWinkAIApi.requestImageText(imagePath, originText, areEqual, new b());
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZonePublishPicToTextViewModel";
    }

    public final void h2(QZoneAutoTexting$TextInfo textInfo) {
        Intrinsics.checkNotNullParameter(textInfo, "textInfo");
        Map<String, QZoneAutoTexting$TextInfo> map = this.selectAiTextInfoMap;
        String str = textInfo.f429485id.get();
        Intrinsics.checkNotNullExpressionValue(str, "textInfo.id.get()");
        map.put(str, textInfo);
    }

    public static /* synthetic */ void T1(l lVar, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        lVar.S1(str);
    }

    public static /* synthetic */ void e2(l lVar, String str, Boolean bool, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            bool = null;
        }
        if ((i3 & 4) != 0) {
            str2 = null;
        }
        lVar.d2(str, bool, str2);
    }
}
