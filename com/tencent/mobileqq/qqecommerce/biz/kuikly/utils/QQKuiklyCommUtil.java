package com.tencent.mobileqq.qqecommerce.biz.kuikly.utils;

import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.container.QQKuiklyFragment;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.container.QQKuiklyRenderView;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.QQKuiklyPageView;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/utils/QQKuiklyCommUtil;", "", "a", "Companion", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class QQKuiklyCommUtil {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\t\u001a\u0004\u0018\u00010\b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/utils/QQKuiklyCommUtil$Companion;", "", "", "data", "d", "dirPath", "", "a", "Lcom/tencent/kuikly/core/render/android/a;", "renderContext", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/container/QQKuiklyRenderView;", "c", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/container/QQKuiklyFragment;", "b", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a(String dirPath) {
            Intrinsics.checkNotNullParameter(dirPath, "dirPath");
            File file = new File(dirPath);
            long j3 = 0;
            if (!file.exists()) {
                return 0L;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(file);
            while (!arrayList.isEmpty()) {
                Object remove = arrayList.remove(0);
                Intrinsics.checkNotNullExpressionValue(remove, "fileList.removeAt(0)");
                File file2 = (File) remove;
                if (file2.isFile()) {
                    j3 += file2.length();
                } else {
                    File[] listFiles = file2.listFiles();
                    if (listFiles != null) {
                        Collections.addAll(arrayList, Arrays.copyOf(listFiles, listFiles.length));
                    }
                }
            }
            return j3;
        }

        public final QQKuiklyFragment b(com.tencent.kuikly.core.render.android.a renderContext) {
            com.tencent.kuikly.core.render.android.a aVar;
            QQKuiklyRenderView c16 = c(renderContext);
            com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h delegate = c16 != null ? c16.getDelegate() : null;
            if (delegate instanceof QQKuiklyFragment) {
                return (QQKuiklyFragment) delegate;
            }
            if (!(delegate instanceof QQKuiklyPageView) || (aVar = ((QQKuiklyPageView) delegate).get_kuiklyRenderContext()) == null) {
                return null;
            }
            return QQKuiklyCommUtil.INSTANCE.b(aVar);
        }

        public final String d(String data) {
            Intrinsics.checkNotNullParameter(data, "data");
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                Charset UTF_8 = StandardCharsets.UTF_8;
                Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                byte[] bytes = data.getBytes(UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                messageDigest.update(bytes);
                String sign = HexUtil.bytes2HexStr(messageDigest.digest());
                messageDigest.reset();
                Intrinsics.checkNotNullExpressionValue(sign, "sign");
                return sign;
            } catch (NoSuchAlgorithmException unused) {
                return "wronghash";
            }
        }

        Companion() {
        }

        public final QQKuiklyRenderView c(com.tencent.kuikly.core.render.android.a renderContext) {
            com.tencent.kuikly.core.render.android.d O0;
            ViewGroup view;
            Sequence generateSequence;
            Sequence filter;
            Object firstOrNull;
            if (renderContext == null || (O0 = renderContext.O0()) == null || (view = O0.getView()) == null) {
                return null;
            }
            generateSequence = SequencesKt__SequencesKt.generateSequence(view, (Function1<? super ViewGroup, ? extends ViewGroup>) ((Function1<? super Object, ? extends Object>) new Function1<ViewGroup, ViewGroup>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.utils.QQKuiklyCommUtil$Companion$getQQKuiklyRenderView$1$1
                @Override // kotlin.jvm.functions.Function1
                public final ViewGroup invoke(ViewGroup it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    ViewParent parent = it.getParent();
                    if (parent instanceof ViewGroup) {
                        return (ViewGroup) parent;
                    }
                    return null;
                }
            }));
            filter = SequencesKt___SequencesKt.filter(generateSequence, new Function1<Object, Boolean>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.utils.QQKuiklyCommUtil$Companion$getQQKuiklyRenderView$lambda$0$$inlined$filterIsInstance$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(Object obj) {
                    return Boolean.valueOf(obj instanceof QQKuiklyRenderView);
                }
            });
            Intrinsics.checkNotNull(filter, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
            firstOrNull = SequencesKt___SequencesKt.firstOrNull(filter);
            return (QQKuiklyRenderView) firstOrNull;
        }
    }
}
