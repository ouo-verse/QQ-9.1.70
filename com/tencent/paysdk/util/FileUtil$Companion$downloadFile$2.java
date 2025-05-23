package com.tencent.paysdk.util;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.adapter.http.HttpHeader;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "Ljava/io/File;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.paysdk.util.FileUtil$Companion$downloadFile$2", f = "FileUtil.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes22.dex */
public final class FileUtil$Companion$downloadFile$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super File>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ String $destFilePath;
    final /* synthetic */ String $urlPath;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileUtil$Companion$downloadFile$2(String str, String str2, Continuation continuation) {
        super(2, continuation);
        this.$destFilePath = str;
        this.$urlPath = str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, str2, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) completion);
        }
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new FileUtil$Companion$downloadFile$2(this.$destFilePath, this.$urlPath, completion);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super File> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
        }
        return ((FileUtil$Companion$downloadFile$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0185 A[Catch: Exception -> 0x0188, TRY_LEAVE, TryCatch #6 {Exception -> 0x0188, blocks: (B:57:0x0180, B:52:0x0185), top: B:56:0x0180 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0180 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        FileOutputStream fileOutputStream;
        File file;
        boolean startsWith$default;
        BufferedInputStream bufferedInputStream;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                String str2 = this.$destFilePath;
                BufferedInputStream bufferedInputStream2 = null;
                try {
                    try {
                        if (TextUtils.isEmpty(str2)) {
                            String str3 = String.valueOf(this.$urlPath.hashCode()) + "";
                            StringBuilder sb5 = new StringBuilder();
                            str = FileUtil.f342059a;
                            sb5.append(str);
                            sb5.append("/");
                            sb5.append(new Date().getTime());
                            sb5.append(str3);
                            str2 = sb5.toString();
                        }
                        long currentTimeMillis = System.currentTimeMillis();
                        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(this.$urlPath, "file://", false, 2, null);
                        if (startsWith$default) {
                            String str4 = this.$urlPath;
                            if (str4 != null) {
                                String substring = str4.substring(7);
                                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
                                bufferedInputStream = new BufferedInputStream(new FileInputStream(substring));
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                            }
                        } else {
                            URLConnection openConnection = new URL(this.$urlPath).openConnection();
                            if (openConnection != null) {
                                HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
                                httpURLConnection.setRequestMethod("GET");
                                httpURLConnection.setRequestProperty(HttpHeader.RSP.CHARSET, "UTF-8");
                                httpURLConnection.setConnectTimeout(10000);
                                httpURLConnection.connect();
                                bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type java.net.HttpURLConnection");
                            }
                        }
                        try {
                            try {
                                file = new File(str2);
                                try {
                                    if (!file.getParentFile().exists()) {
                                        file.getParentFile().mkdirs();
                                    }
                                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                                    try {
                                        byte[] bArr = new byte[1024];
                                        while (true) {
                                            Integer boxInt = Boxing.boxInt(bufferedInputStream.read(bArr));
                                            int intValue = boxInt.intValue();
                                            if (boxInt.intValue() == -1) {
                                                break;
                                            }
                                            fileOutputStream2.write(bArr, 0, intValue);
                                        }
                                        com.tencent.paysdk.log.c.b("FileUtil", "downloadFile urlPath=" + this.$urlPath + " size=" + file.length() + "byte(s) cost=" + (System.currentTimeMillis() - currentTimeMillis));
                                        bufferedInputStream.close();
                                        fileOutputStream2.close();
                                    } catch (Exception e16) {
                                        fileOutputStream = fileOutputStream2;
                                        e = e16;
                                        bufferedInputStream2 = bufferedInputStream;
                                        try {
                                            com.tencent.paysdk.log.c.a("FileUtil", "downloadFile err=" + e);
                                            if (bufferedInputStream2 != null) {
                                                bufferedInputStream2.close();
                                            }
                                            if (fileOutputStream != null) {
                                                fileOutputStream.close();
                                            }
                                            return file;
                                        } catch (Throwable th5) {
                                            th = th5;
                                            if (bufferedInputStream2 != null) {
                                                try {
                                                    bufferedInputStream2.close();
                                                } catch (Exception unused) {
                                                    throw th;
                                                }
                                            }
                                            if (fileOutputStream != null) {
                                                fileOutputStream.close();
                                            }
                                            throw th;
                                        }
                                    } catch (Throwable th6) {
                                        fileOutputStream = fileOutputStream2;
                                        th = th6;
                                        bufferedInputStream2 = bufferedInputStream;
                                        if (bufferedInputStream2 != null) {
                                        }
                                        if (fileOutputStream != null) {
                                        }
                                        throw th;
                                    }
                                } catch (Exception e17) {
                                    e = e17;
                                    fileOutputStream = null;
                                }
                            } catch (Exception e18) {
                                e = e18;
                                fileOutputStream = null;
                                file = null;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            fileOutputStream = null;
                        }
                    } catch (Exception e19) {
                        e = e19;
                        fileOutputStream = null;
                        file = null;
                    } catch (Throwable th8) {
                        th = th8;
                        fileOutputStream = null;
                    }
                } catch (Exception unused2) {
                }
                return file;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return iPatchRedirector.redirect((short) 1, (Object) this, obj);
    }
}
