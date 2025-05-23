package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Timer;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ImageInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.repo.QSearchAICardNetRepo;
import com.tencent.kuikly.core.base.w;
import com.tencent.kuikly.core.coroutines.BuildersKt;
import com.tencent.kuikly.core.coroutines.e;
import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes32.dex */
public final class QSearchAIPictureCardViewModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchAIPictureCardViewModel.class, "imageInfo", "getImageInfo()Lcom/tencent/hippykotlin/demo/pages/qsearch_detail_page/data/pb/ImageInfo;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchAIPictureCardViewModel.class, "imageSize", "getImageSize()Lcom/tencent/kuikly/core/base/Size;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchAIPictureCardViewModel.class, "cardStatus", "getCardStatus()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchAIPictureCardViewModel.class, "cardHeight", "getCardHeight()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchAIPictureCardViewModel.class, "cardText", "getCardText()Ljava/lang/String;", 0)};
    public long endTime;
    public int errorCode;
    public final String keyword;
    public final Lazy repo$delegate;
    public Timer requestTimer;
    public long startTime;
    public boolean stoped;
    public final Lazy viewModelScope$delegate;
    public final ReadWriteProperty imageInfo$delegate = c.a(null);
    public final ReadWriteProperty imageSize$delegate = c.a(new w(129.0f, 194.0f));
    public final ReadWriteProperty cardStatus$delegate = c.a(0);
    public final ReadWriteProperty cardHeight$delegate = c.a(Float.valueOf(36.0f));
    public final ReadWriteProperty cardText$delegate = c.a("\u52a0\u8f7d\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5...");

    public QSearchAIPictureCardViewModel(String str) {
        Lazy lazy;
        Lazy lazy2;
        this.keyword = str;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QSearchAICardNetRepo>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardViewModel$repo$2
            @Override // kotlin.jvm.functions.Function0
            public final QSearchAICardNetRepo invoke() {
                return new QSearchAICardNetRepo();
            }
        });
        this.repo$delegate = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<e>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.ai_picture.QSearchAIPictureCardViewModel$viewModelScope$2
            @Override // kotlin.jvm.functions.Function0
            public final e invoke() {
                return e.f117232d;
            }
        });
        this.viewModelScope$delegate = lazy2;
    }

    public static final void access$notifyFailed(QSearchAIPictureCardViewModel qSearchAIPictureCardViewModel, int i3) {
        qSearchAIPictureCardViewModel.getClass();
        qSearchAIPictureCardViewModel.endTime = Utils.INSTANCE.currentBridgeModule().currentTimeStamp();
        qSearchAIPictureCardViewModel.setCardStatus(3);
        qSearchAIPictureCardViewModel.setCardHeight(97.0f);
        qSearchAIPictureCardViewModel.errorCode = i3;
    }

    public final com.tencent.kuikly.core.nvi.serialization.json.e buildReportData(com.tencent.kuikly.core.nvi.serialization.json.e eVar) {
        long j3 = this.endTime - this.startTime;
        if (j3 <= 0) {
            j3 = 0;
        }
        eVar.u("duration", j3);
        eVar.t(CheckForwardServlet.KEY_ERR_CODE, this.errorCode);
        return eVar;
    }

    public final int getCardStatus() {
        return ((Number) this.cardStatus$delegate.getValue(this, $$delegatedProperties[2])).intValue();
    }

    public final ImageInfo getImageInfo() {
        return (ImageInfo) this.imageInfo$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final w getImageSize() {
        return (w) this.imageSize$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final void innerLoadData(String str, boolean z16) {
        BuildersKt.e((e) this.viewModelScope$delegate.getValue(), null, null, new QSearchAIPictureCardViewModel$innerLoadData$1(this, str, z16, null), 3, null);
    }

    public final void setCardHeight(float f16) {
        this.cardHeight$delegate.setValue(this, $$delegatedProperties[3], Float.valueOf(f16));
    }

    public final void setCardStatus(int i3) {
        this.cardStatus$delegate.setValue(this, $$delegatedProperties[2], Integer.valueOf(i3));
    }
}
