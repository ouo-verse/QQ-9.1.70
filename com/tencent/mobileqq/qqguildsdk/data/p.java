package com.tencent.mobileqq.qqguildsdk.data;

import androidx.annotation.NonNull;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProShareAttaData;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    public final GProShareAttaData f266732a;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private GProShareAttaData f266733a = new GProShareAttaData();

        public a b(String str) {
            this.f266733a.appVersion = str;
            return this;
        }

        public a c(String str) {
            this.f266733a.attaContentId = str;
            return this;
        }

        public p d() {
            return new p(this);
        }

        public a e(String str) {
            this.f266733a.channelId = str;
            return this;
        }

        public a f(String str) {
            this.f266733a.contentId = str;
            return this;
        }

        public a g(String str) {
            this.f266733a.guildId = str;
            return this;
        }

        public a h(String str) {
            this.f266733a.platformId = str;
            return this;
        }

        public a i(String str) {
            this.f266733a.sessionId = str;
            return this;
        }

        public a j(String str) {
            this.f266733a.shareContentType = str;
            return this;
        }

        public a k(String str) {
            this.f266733a.sharePanelPageSource = str;
            return this;
        }

        public a l(String str) {
            this.f266733a.shareSource = str;
            return this;
        }

        public a m(String str) {
            this.f266733a.streamPginSourceName = str;
            return this;
        }

        public a n(String str) {
            this.f266733a.timeStamp = str;
            return this;
        }

        public a o(ArrayList<String> arrayList) {
            this.f266733a.toUinList = arrayList;
            return this;
        }

        public a p(String str) {
            this.f266733a.userAgent = str;
            return this;
        }

        public a q(String str) {
            this.f266733a.visitFrom = str;
            return this;
        }
    }

    p(a aVar) {
        this.f266732a = aVar.f266733a;
    }

    public GProShareAttaData a() {
        return this.f266732a;
    }

    @NonNull
    public String toString() {
        return this.f266732a.toString();
    }
}
