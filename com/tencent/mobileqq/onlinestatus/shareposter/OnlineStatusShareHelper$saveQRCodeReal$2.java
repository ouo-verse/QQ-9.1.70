package com.tencent.mobileqq.onlinestatus.shareposter;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import com.tencent.weiyun.transmission.db.JobDbManager;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.onlinestatus.shareposter.OnlineStatusShareHelper$saveQRCodeReal$2", f = "OnlineStatusShareHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes16.dex */
public final class OnlineStatusShareHelper$saveQRCodeReal$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bitmap $bitmap;
    final /* synthetic */ Ref.ObjectRef<Uri> $insertUri;
    final /* synthetic */ Ref.BooleanRef $isSuccess;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnlineStatusShareHelper$saveQRCodeReal$2(Ref.ObjectRef<Uri> objectRef, Ref.BooleanRef booleanRef, Bitmap bitmap, Continuation<? super OnlineStatusShareHelper$saveQRCodeReal$2> continuation) {
        super(2, continuation);
        this.$insertUri = objectRef;
        this.$isSuccess = booleanRef;
        this.$bitmap = bitmap;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new OnlineStatusShareHelper$saveQRCodeReal$2(this.$insertUri, this.$isSuccess, this.$bitmap, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x011a  */
    /* JADX WARN: Type inference failed for: r11v3, types: [T, android.net.Uri] */
    /* JADX WARN: Type inference failed for: r5v10, types: [java.io.OutputStream, T] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        StringBuilder sb5;
        Uri uri;
        Bitmap.CompressFormat compressFormat;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Uri uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            ContentResolver contentResolver = BaseApplication.getContext().getContentResolver();
            String str = "online_status_share_poster_" + String.valueOf(System.currentTimeMillis());
            ContentValues contentValues = new ContentValues();
            contentValues.put("title", str);
            contentValues.put(InputMethodUtil.SOUGOU_URI_DISPLAYNAME, str);
            contentValues.put(JobDbManager.COL_UP_MIME_TYPE, "image/jpeg");
            this.$insertUri.element = contentResolver.insert(uri2, contentValues);
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            try {
                try {
                    try {
                        Uri uri3 = this.$insertUri.element;
                        if (uri3 != null) {
                            objectRef.element = contentResolver.openOutputStream(uri3);
                        }
                        if (objectRef.element != 0) {
                            Ref.BooleanRef booleanRef = this.$isSuccess;
                            Bitmap bitmap = this.$bitmap;
                            compressFormat = OnlineStatusShareHelper.f256247i;
                            booleanRef.element = bitmap.compress(compressFormat, 100, (OutputStream) objectRef.element);
                        }
                        OutputStream outputStream = (OutputStream) objectRef.element;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e16) {
                                e = e16;
                                sb5 = new StringBuilder();
                                sb5.append("saveQRCodeReal finally, error = ");
                                sb5.append(e);
                                QLog.e("OnlineStatusShareHelper", 1, sb5.toString());
                                if (!this.$isSuccess.element) {
                                }
                                return Unit.INSTANCE;
                            }
                        }
                    } catch (FileNotFoundException e17) {
                        QLog.e("OnlineStatusShareHelper", 1, "saveQRCodeReal, error = " + e17);
                        OutputStream outputStream2 = (OutputStream) objectRef.element;
                        if (outputStream2 != null) {
                            try {
                                outputStream2.close();
                            } catch (IOException e18) {
                                e = e18;
                                sb5 = new StringBuilder();
                                sb5.append("saveQRCodeReal finally, error = ");
                                sb5.append(e);
                                QLog.e("OnlineStatusShareHelper", 1, sb5.toString());
                                if (!this.$isSuccess.element) {
                                }
                                return Unit.INSTANCE;
                            }
                        }
                    } catch (OutOfMemoryError e19) {
                        QLog.e("OnlineStatusShareHelper", 1, "saveQRCodeReal, error = " + e19);
                        OutputStream outputStream3 = (OutputStream) objectRef.element;
                        if (outputStream3 != null) {
                            try {
                                outputStream3.close();
                            } catch (IOException e26) {
                                e = e26;
                                sb5 = new StringBuilder();
                                sb5.append("saveQRCodeReal finally, error = ");
                                sb5.append(e);
                                QLog.e("OnlineStatusShareHelper", 1, sb5.toString());
                                if (!this.$isSuccess.element) {
                                    Boxing.boxInt(py3.b.e(contentResolver, uri, null, null));
                                }
                                return Unit.INSTANCE;
                            }
                        }
                    }
                } catch (IllegalStateException e27) {
                    QLog.e("OnlineStatusShareHelper", 1, "saveQRCodeReal, error = " + e27);
                    OutputStream outputStream4 = (OutputStream) objectRef.element;
                    if (outputStream4 != null) {
                        try {
                            outputStream4.close();
                        } catch (IOException e28) {
                            e = e28;
                            sb5 = new StringBuilder();
                            sb5.append("saveQRCodeReal finally, error = ");
                            sb5.append(e);
                            QLog.e("OnlineStatusShareHelper", 1, sb5.toString());
                            if (!this.$isSuccess.element) {
                            }
                            return Unit.INSTANCE;
                        }
                    }
                }
                if (!this.$isSuccess.element && (uri = this.$insertUri.element) != null) {
                    Boxing.boxInt(py3.b.e(contentResolver, uri, null, null));
                }
                return Unit.INSTANCE;
            } catch (Throwable th5) {
                OutputStream outputStream5 = (OutputStream) objectRef.element;
                if (outputStream5 != null) {
                    try {
                        outputStream5.close();
                    } catch (IOException e29) {
                        QLog.e("OnlineStatusShareHelper", 1, "saveQRCodeReal finally, error = " + e29);
                    }
                }
                throw th5;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((OnlineStatusShareHelper$saveQRCodeReal$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
