package com.qzone.reborn.share;

import androidx.lifecycle.MutableLiveData;
import com.qzone.reborn.base.n;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 #2\u00020\u0001:\u0001$B\u0007\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016R(\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R$\u0010\u001c\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\t8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\f\u001a\u0004\b\u001f\u0010\u000e\u00a8\u0006%"}, d2 = {"Lcom/qzone/reborn/share/i;", "Lcom/qzone/reborn/base/n;", "", "getLogTag", "", "P1", "value", "", "R1", "Landroidx/lifecycle/MutableLiveData;", "", "i", "Landroidx/lifecycle/MutableLiveData;", "O1", "()Landroidx/lifecycle/MutableLiveData;", "setDisplayStates", "(Landroidx/lifecycle/MutableLiveData;)V", "displayStates", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/Object;", "data", "Lcom/qzone/reborn/share/d;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/share/d;", "N1", "()Lcom/qzone/reborn/share/d;", "Q1", "(Lcom/qzone/reborn/share/d;)V", DownloadInfo.spKey_Config, "Lwd/f;", "D", "M1", "broadcastMessageData", "<init>", "()V", "E", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class i extends n {

    /* renamed from: C, reason: from kotlin metadata */
    private d config;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private Object data;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private MutableLiveData<Boolean> displayStates = new MutableLiveData<>();

    /* renamed from: D, reason: from kotlin metadata */
    private final MutableLiveData<wd.f> broadcastMessageData = new MutableLiveData<>();

    public final MutableLiveData<wd.f> M1() {
        return this.broadcastMessageData;
    }

    /* renamed from: N1, reason: from getter */
    public final d getConfig() {
        return this.config;
    }

    public final MutableLiveData<Boolean> O1() {
        return this.displayStates;
    }

    /* renamed from: P1, reason: from getter */
    public Object getData() {
        return this.data;
    }

    public final void Q1(d dVar) {
        this.config = dVar;
    }

    public void R1(Object value) {
        this.data = value;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return "QzoneShareViewModel";
    }
}
