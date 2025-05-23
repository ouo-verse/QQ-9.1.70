package com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.k;
import com.tencent.kuikly.core.timer.TimerKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class LBPLuckyBagPendantAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(LBPLuckyBagPendantAttr.class, "bigAnimationUrl", "getBigAnimationUrl()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(LBPLuckyBagPendantAttr.class, "playStatus", "getPlayStatus()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(LBPLuckyBagPendantAttr.class, "pendantAnimationUrl", "getPendantAnimationUrl()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(LBPLuckyBagPendantAttr.class, "pendantIconUrl", "getPendantIconUrl()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(LBPLuckyBagPendantAttr.class, "statusAreaOpacity", "getStatusAreaOpacity()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(LBPLuckyBagPendantAttr.class, "reportPlayStatus", "getReportPlayStatus()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(LBPLuckyBagPendantAttr.class, "isHRC", "isHRC()I", 0)};
    public LBPPlayDetail curDetail;
    public double localTimeDiffServe;
    public final ReadWriteProperty bigAnimationUrl$delegate = c.a(null);
    public final ReadWriteProperty playStatus$delegate = c.a(0);
    public final ReadWriteProperty pendantAnimationUrl$delegate = c.a(null);
    public final ReadWriteProperty pendantIconUrl$delegate = c.a(null);
    public final ReadWriteProperty statusAreaOpacity$delegate = c.a(Float.valueOf(0.0f));
    public final ReadWriteProperty reportPlayStatus$delegate = c.a(0);
    public final ReadWriteProperty isHRC$delegate = c.a(0);

    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void bigAnimationDidFinish$qecommerce_biz_release() {
        boolean z16;
        LBPPlayConfig lBPPlayConfig;
        String str;
        LBPPlayInfo lBPPlayInfo;
        String bigAnimationUrl = getBigAnimationUrl();
        int i3 = 0;
        if (bigAnimationUrl != null) {
            if (bigAnimationUrl.length() > 0) {
                z16 = true;
                if (z16) {
                    return;
                }
                LBPPlayDetail lBPPlayDetail = this.curDetail;
                if (lBPPlayDetail != null && (lBPPlayConfig = lBPPlayDetail.conf) != null && (str = lBPPlayConfig.pendantAnimationUrl) != null) {
                    setPendantAnimationUrl(str);
                    showStatusArea$qecommerce_biz_release(true);
                    LBPPlayDetail lBPPlayDetail2 = this.curDetail;
                    if (lBPPlayDetail2 != null && (lBPPlayInfo = lBPPlayDetail2.info) != null) {
                        i3 = lBPPlayInfo.status;
                    }
                    setPlayStatus(i3);
                }
                setBigAnimationUrl(null);
                return;
            }
        }
        z16 = false;
        if (z16) {
        }
    }

    public final String getBigAnimationUrl() {
        return (String) this.bigAnimationUrl$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final String getPendantAnimationUrl() {
        return (String) this.pendantAnimationUrl$delegate.getValue(this, $$delegatedProperties[2]);
    }

    public final int getPlayStatus() {
        return ((Number) this.playStatus$delegate.getValue(this, $$delegatedProperties[1])).intValue();
    }

    public final int getReportPlayStatus() {
        return ((Number) this.reportPlayStatus$delegate.getValue(this, $$delegatedProperties[5])).intValue();
    }

    public final void setBigAnimationUrl(String str) {
        this.bigAnimationUrl$delegate.setValue(this, $$delegatedProperties[0], str);
    }

    public final void setPendantAnimationUrl(String str) {
        this.pendantAnimationUrl$delegate.setValue(this, $$delegatedProperties[2], str);
    }

    public final void setPendantIconUrl(String str) {
        this.pendantIconUrl$delegate.setValue(this, $$delegatedProperties[3], str);
    }

    public final void setPlayStatus(int i3) {
        this.playStatus$delegate.setValue(this, $$delegatedProperties[1], Integer.valueOf(i3));
    }

    public final void setStatusAreaOpacity(float f16) {
        this.statusAreaOpacity$delegate.setValue(this, $$delegatedProperties[4], Float.valueOf(f16));
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void updateLuckyBagData(final LBPPlayDetail lBPPlayDetail) {
        boolean z16;
        LBPPlayConfig lBPPlayConfig;
        boolean z17;
        String str;
        boolean z18;
        String str2;
        String str3;
        LBPPlayInfo lBPPlayInfo;
        if (lBPPlayDetail.conf == null || lBPPlayDetail.info == null) {
            return;
        }
        LBPPlayDetail lBPPlayDetail2 = this.curDetail;
        Integer valueOf = (lBPPlayDetail2 == null || (lBPPlayInfo = lBPPlayDetail2.info) == null) ? null : Integer.valueOf(lBPPlayInfo.startTime);
        LBPPlayInfo lBPPlayInfo2 = lBPPlayDetail.info;
        boolean z19 = !Intrinsics.areEqual(valueOf, lBPPlayInfo2 != null ? Integer.valueOf(lBPPlayInfo2.startTime) : null);
        this.curDetail = lBPPlayDetail;
        LBPPlayInfo lBPPlayInfo3 = lBPPlayDetail.info;
        if (lBPPlayInfo3 != null) {
            this.reportPlayStatus$delegate.setValue(this, $$delegatedProperties[5], Integer.valueOf(Integer.valueOf(lBPPlayInfo3.status).intValue()));
        }
        if (z19) {
            setPlayStatus(0);
            setPendantAnimationUrl(null);
            setPendantIconUrl(null);
            setBigAnimationUrl(null);
            setStatusAreaOpacity(0.0f);
            LBPPlayInfo lBPPlayInfo4 = lBPPlayDetail.info;
            if (!(lBPPlayInfo4 != null && lBPPlayInfo4.status == 3)) {
                if (!(lBPPlayInfo4 != null && lBPPlayInfo4.status == 2)) {
                    LBPPlayConfig lBPPlayConfig2 = lBPPlayDetail.conf;
                    if (lBPPlayConfig2 != null && (str3 = lBPPlayConfig2.largeAnimationUrl) != null) {
                        if (str3.length() > 0) {
                            z16 = true;
                            if (z16) {
                                LBPPlayConfig lBPPlayConfig3 = lBPPlayDetail.conf;
                                if (lBPPlayConfig3 != null && (str2 = lBPPlayConfig3.pendantAnimationUrl) != null) {
                                    if (str2.length() > 0) {
                                        z18 = true;
                                        if (z18) {
                                            getPager().addNextTickTask(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LBPLuckyBagPendantAttr$updateLuckyBagData$2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(0);
                                                }

                                                @Override // kotlin.jvm.functions.Function0
                                                public final Unit invoke() {
                                                    LBPLuckyBagPendantAttr lBPLuckyBagPendantAttr = LBPLuckyBagPendantAttr.this;
                                                    LBPPlayConfig lBPPlayConfig4 = lBPPlayDetail.conf;
                                                    String str4 = lBPPlayConfig4 != null ? lBPPlayConfig4.largeAnimationUrl : null;
                                                    Intrinsics.checkNotNull(str4);
                                                    lBPLuckyBagPendantAttr.setBigAnimationUrl(str4);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return;
                                        }
                                    }
                                }
                                z18 = false;
                                if (z18) {
                                }
                            }
                            lBPPlayConfig = lBPPlayDetail.conf;
                            if (lBPPlayConfig != null && (str = lBPPlayConfig.pendantAnimationUrl) != null) {
                                if (str.length() <= 0) {
                                    z17 = true;
                                    if (z17) {
                                        LBPPlayConfig lBPPlayConfig4 = lBPPlayDetail.conf;
                                        setPendantAnimationUrl(lBPPlayConfig4 != null ? lBPPlayConfig4.pendantAnimationUrl : null);
                                        showStatusArea$qecommerce_biz_release(true);
                                        LBPPlayInfo lBPPlayInfo5 = lBPPlayDetail.info;
                                        setPlayStatus(lBPPlayInfo5 != null ? lBPPlayInfo5.status : 0);
                                        return;
                                    }
                                    LBPPlayConfig lBPPlayConfig5 = lBPPlayDetail.conf;
                                    setPendantIconUrl(lBPPlayConfig5 != null ? lBPPlayConfig5.pendantIcon : null);
                                    showStatusArea$qecommerce_biz_release(false);
                                    LBPPlayInfo lBPPlayInfo6 = lBPPlayDetail.info;
                                    setPlayStatus(lBPPlayInfo6 != null ? lBPPlayInfo6.status : 0);
                                    return;
                                }
                            }
                            z17 = false;
                            if (z17) {
                            }
                        }
                    }
                    z16 = false;
                    if (z16) {
                    }
                    lBPPlayConfig = lBPPlayDetail.conf;
                    if (lBPPlayConfig != null) {
                        if (str.length() <= 0) {
                        }
                    }
                    z17 = false;
                    if (z17) {
                    }
                }
            }
            LBPPlayConfig lBPPlayConfig6 = lBPPlayDetail.conf;
            setPendantIconUrl(lBPPlayConfig6 != null ? lBPPlayConfig6.pendantIcon : null);
            showStatusArea$qecommerce_biz_release(false);
            LBPPlayInfo lBPPlayInfo7 = lBPPlayDetail.info;
            Intrinsics.checkNotNull(lBPPlayInfo7);
            setPlayStatus(lBPPlayInfo7.status);
            return;
        }
        LBPPlayInfo lBPPlayInfo8 = lBPPlayDetail.info;
        setPlayStatus(lBPPlayInfo8 != null ? lBPPlayInfo8.status : 0);
    }

    public final void showStatusArea$qecommerce_biz_release(boolean z16) {
        if (z16) {
            TimerKt.e(getPagerId(), 533, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LBPLuckyBagPendantAttr$showStatusArea$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    String pendantAnimationUrl = LBPLuckyBagPendantAttr.this.getPendantAnimationUrl();
                    boolean z17 = false;
                    if (pendantAnimationUrl != null) {
                        if (pendantAnimationUrl.length() > 0) {
                            z17 = true;
                        }
                    }
                    if (z17) {
                        LBPLuckyBagPendantAttr.this.setStatusAreaOpacity(1.0f);
                    }
                    return Unit.INSTANCE;
                }
            });
        } else {
            setStatusAreaOpacity(1.0f);
        }
    }
}
