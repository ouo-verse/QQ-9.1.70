package com.tencent.mobileqq.wink.model;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0002\u0004\u000bB\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016R(\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR(\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\"\u0010\u0014\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u000f\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/wink/model/a;", "", "", "Lcom/tencent/mobileqq/wink/model/a$b;", "a", "Ljava/util/List;", "()Ljava/util/List;", "setFaces", "(Ljava/util/List;)V", "faces", "Lcom/tencent/mobileqq/wink/model/a$a;", "b", "setTags", ComicCancelRedPointPopItemData.JSON_KEY_TAGS, "", "c", "J", "getCostTime", "()J", "(J)V", "costTime", "<init>", "()V", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<b> faces = new ArrayList();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<C9064a> tags = new ArrayList();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long costTime;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\u0012\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\u0003\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/wink/model/a$a;", "", "", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "f", "(Ljava/lang/String;)V", "classifyType", "b", "e", "classifyName", "", UserInfo.SEX_FEMALE, "()F", "d", "(F)V", "classifyConfidence", "<init>", "()V", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.model.a$a, reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public static final class C9064a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String classifyType;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String classifyName;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private float classifyConfidence;

        /* renamed from: a, reason: from getter */
        public final float getClassifyConfidence() {
            return this.classifyConfidence;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final String getClassifyName() {
            return this.classifyName;
        }

        @Nullable
        /* renamed from: c, reason: from getter */
        public final String getClassifyType() {
            return this.classifyType;
        }

        public final void d(float f16) {
            this.classifyConfidence = f16;
        }

        public final void e(@Nullable String str) {
            this.classifyName = str;
        }

        public final void f(@Nullable String str) {
            this.classifyType = str;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010!\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0005\"\u0004\b\u000b\u0010\u0007R\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0005\"\u0004\b\u000f\u0010\u0007R\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\r\u0010\u0005\"\u0004\b\u0011\u0010\u0007R(\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0014\u001a\u0004\b\t\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/wink/model/a$b;", "", "", "a", "I", "()I", "f", "(I)V", "age", "b", "e", "j", "gender", "c", "d", "i", "frameW", h.F, "frameH", "", "Ljava/util/List;", "()Ljava/util/List;", "g", "(Ljava/util/List;)V", "facedRect", "<init>", "()V", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int age;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int gender;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private int frameW;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int frameH;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private List<Object> facedRect = new ArrayList();

        /* renamed from: a, reason: from getter */
        public final int getAge() {
            return this.age;
        }

        @NotNull
        public final List<Object> b() {
            return this.facedRect;
        }

        /* renamed from: c, reason: from getter */
        public final int getFrameH() {
            return this.frameH;
        }

        /* renamed from: d, reason: from getter */
        public final int getFrameW() {
            return this.frameW;
        }

        /* renamed from: e, reason: from getter */
        public final int getGender() {
            return this.gender;
        }

        public final void f(int i3) {
            this.age = i3;
        }

        public final void g(@NotNull List<Object> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.facedRect = list;
        }

        public final void h(int i3) {
            this.frameH = i3;
        }

        public final void i(int i3) {
            this.frameW = i3;
        }

        public final void j(int i3) {
            this.gender = i3;
        }
    }

    @NotNull
    public final List<b> a() {
        return this.faces;
    }

    @NotNull
    public final List<C9064a> b() {
        return this.tags;
    }

    public final void c(long j3) {
        this.costTime = j3;
    }
}
