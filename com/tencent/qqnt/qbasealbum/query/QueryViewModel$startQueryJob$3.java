package com.tencent.qqnt.qbasealbum.query;

import android.net.Uri;
import android.provider.MediaStore;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.qqnt.qbasealbum.query.QueryViewModel$startQueryJob$3", f = "QueryViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes25.dex */
public final class QueryViewModel$startQueryJob$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ int $end;
    final /* synthetic */ FromType $fromType;
    final /* synthetic */ List<String> $list;
    final /* synthetic */ boolean $needPickerPayload;
    final /* synthetic */ ScrollDirection $scrollDirection;
    final /* synthetic */ int $start;
    int label;
    final /* synthetic */ QueryViewModel this$0;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public /* synthetic */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f361486a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f361487b;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44699);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[ScrollDirection.values().length];
            try {
                iArr[ScrollDirection.UP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ScrollDirection.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ScrollDirection.DEFAULT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f361486a = iArr;
            int[] iArr2 = new int[FromType.values().length];
            try {
                iArr2[FromType.FROM_PREVIEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[FromType.FROM_PICKER.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            f361487b = iArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QueryViewModel$startQueryJob$3(List<String> list, QueryViewModel queryViewModel, ScrollDirection scrollDirection, int i3, int i16, FromType fromType, boolean z16, Continuation<? super QueryViewModel$startQueryJob$3> continuation) {
        super(2, continuation);
        this.$list = list;
        this.this$0 = queryViewModel;
        this.$scrollDirection = scrollDirection;
        this.$start = i3;
        this.$end = i16;
        this.$fromType = fromType;
        this.$needPickerPayload = z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, list, queryViewModel, scrollDirection, Integer.valueOf(i3), Integer.valueOf(i16), fromType, Boolean.valueOf(z16), continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new QueryViewModel$startQueryJob$3(this.$list, this.this$0, this.$scrollDirection, this.$start, this.$end, this.$fromType, this.$needPickerPayload, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        List chunked;
        int i3;
        int i16;
        String joinToString$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                long currentTimeMillis = System.currentTimeMillis();
                chunked = CollectionsKt___CollectionsKt.chunked(this.$list, 500);
                QueryViewModel queryViewModel = this.this$0;
                Iterator it = chunked.iterator();
                while (it.hasNext()) {
                    joinToString$default = CollectionsKt___CollectionsKt.joinToString$default((List) it.next(), ",", null, null, 0, null, QueryViewModel$startQueryJob$3$1$selection$1.INSTANCE, 30, null);
                    String str = "_id IN (" + joinToString$default + ")";
                    String[] strArr = {"_id", "_data"};
                    Uri EXTERNAL_CONTENT_URI = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    Intrinsics.checkNotNullExpressionValue(EXTERNAL_CONTENT_URI, "EXTERNAL_CONTENT_URI");
                    queryViewModel.h2(EXTERNAL_CONTENT_URI, strArr, str);
                    Uri EXTERNAL_CONTENT_URI2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                    Intrinsics.checkNotNullExpressionValue(EXTERNAL_CONTENT_URI2, "EXTERNAL_CONTENT_URI");
                    queryViewModel.h2(EXTERNAL_CONTENT_URI2, strArr, str);
                }
                ox3.a.c(this.this$0.getTAG(), new Function0<String>(currentTimeMillis) { // from class: com.tencent.qqnt.qbasealbum.query.QueryViewModel$startQueryJob$3.2
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ long $startTime;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.$startTime = currentTimeMillis;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, currentTimeMillis);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final String invoke() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                        }
                        return "loadMoreMedia cost: " + (System.currentTimeMillis() - this.$startTime);
                    }
                });
                int i17 = a.f361486a[this.$scrollDirection.ordinal()];
                if (i17 != 1) {
                    if (i17 != 2) {
                        if (i17 == 3) {
                            this.this$0.i2(new com.tencent.qqnt.qbasealbum.query.a(this.$start, this.$end));
                            this.this$0.startPos = this.$start;
                            this.this$0.endPos = this.$end;
                        }
                    } else {
                        QueryViewModel queryViewModel2 = this.this$0;
                        i16 = queryViewModel2.startPos;
                        queryViewModel2.i2(new com.tencent.qqnt.qbasealbum.query.a(i16, this.$end));
                    }
                } else {
                    QueryViewModel queryViewModel3 = this.this$0;
                    int i18 = this.$start;
                    i3 = queryViewModel3.endPos;
                    queryViewModel3.i2(new com.tencent.qqnt.qbasealbum.query.a(i18, i3));
                }
                int i19 = a.f361487b[this.$fromType.ordinal()];
                if (i19 == 1) {
                    this.this$0.f2(this.$start, this.$end);
                } else if (i19 == 2 && this.$needPickerPayload) {
                    this.this$0.d2(this.$start, this.$end);
                }
                this.this$0.queryJob = null;
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((QueryViewModel$startQueryJob$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
