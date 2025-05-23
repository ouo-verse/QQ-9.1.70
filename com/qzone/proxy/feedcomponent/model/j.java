package com.qzone.proxy.feedcomponent.model;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00142\u00020\u0001:\u0002\u0003\nB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000e\u0010\bR,\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0012\u001a\u0004\b\u0003\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/qzone/proxy/feedcomponent/model/j;", "", "", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "g", "(Ljava/lang/String;)V", "title", "b", "d", tl.h.F, "titleRight", "f", "rightJumpUrl", "", "Lcom/qzone/proxy/feedcomponent/model/j$a;", "Ljava/util/List;", "()Ljava/util/List;", "e", "(Ljava/util/List;)V", "listCardData", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String title;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String titleRight;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private String rightJumpUrl;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private List<a> listCardData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\"\u0010#R$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0005\"\u0004\b\u000b\u0010\u0007R$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0005\"\u0004\b\u000f\u0010\u0007R$\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0005\"\u0004\b\u0013\u0010\u0007R$\u0010\u001b\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0011\u0010\u0005\"\u0004\b\u001c\u0010\u0007R$\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\r\u0010\u0005\"\u0004\b\u001e\u0010\u0007R$\u0010!\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\t\u0010\u0005\"\u0004\b \u0010\u0007\u00a8\u0006$"}, d2 = {"Lcom/qzone/proxy/feedcomponent/model/j$a;", "", "", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "i", "(Ljava/lang/String;)V", "adId", "b", tl.h.F, "p", MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO, "c", "g", "o", "title", "d", "f", DomainData.DOMAIN_NAME, "summary", "Lcom/qzone/proxy/feedcomponent/model/PictureItem;", "e", "Lcom/qzone/proxy/feedcomponent/model/PictureItem;", "()Lcom/qzone/proxy/feedcomponent/model/PictureItem;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/qzone/proxy/feedcomponent/model/PictureItem;)V", "pictureItem", "l", WadlProxyConsts.KEY_JUMP_URL, "k", "buttonText", "j", "buttonJump", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes39.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private String adId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private String traceInfo;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private String title;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private String summary;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private PictureItem pictureItem;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private String jumpUrl;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private String buttonText;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private String buttonJump;

        /* renamed from: a, reason: from getter */
        public final String getAdId() {
            return this.adId;
        }

        /* renamed from: b, reason: from getter */
        public final String getButtonJump() {
            return this.buttonJump;
        }

        /* renamed from: c, reason: from getter */
        public final String getButtonText() {
            return this.buttonText;
        }

        /* renamed from: d, reason: from getter */
        public final String getJumpUrl() {
            return this.jumpUrl;
        }

        /* renamed from: e, reason: from getter */
        public final PictureItem getPictureItem() {
            return this.pictureItem;
        }

        /* renamed from: f, reason: from getter */
        public final String getSummary() {
            return this.summary;
        }

        /* renamed from: g, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* renamed from: h, reason: from getter */
        public final String getTraceInfo() {
            return this.traceInfo;
        }

        public final void i(String str) {
            this.adId = str;
        }

        public final void j(String str) {
            this.buttonJump = str;
        }

        public final void k(String str) {
            this.buttonText = str;
        }

        public final void l(String str) {
            this.jumpUrl = str;
        }

        public final void m(PictureItem pictureItem) {
            this.pictureItem = pictureItem;
        }

        public final void n(String str) {
            this.summary = str;
        }

        public final void o(String str) {
            this.title = str;
        }

        public final void p(String str) {
            this.traceInfo = str;
        }
    }

    public final List<a> a() {
        return this.listCardData;
    }

    /* renamed from: b, reason: from getter */
    public final String getRightJumpUrl() {
        return this.rightJumpUrl;
    }

    /* renamed from: c, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: d, reason: from getter */
    public final String getTitleRight() {
        return this.titleRight;
    }

    public final void e(List<a> list) {
        this.listCardData = list;
    }

    public final void f(String str) {
        this.rightJumpUrl = str;
    }

    public final void g(String str) {
        this.title = str;
    }

    public final void h(String str) {
        this.titleRight = str;
    }
}
