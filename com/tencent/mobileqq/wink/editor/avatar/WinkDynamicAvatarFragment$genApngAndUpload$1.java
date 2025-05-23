package com.tencent.mobileqq.wink.editor.avatar;

import android.graphics.Rect;
import android.os.SystemClock;
import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import com.tencent.mobileqq.wink.editor.view.WinkSegClipView;
import com.tencent.mobileqq.wink.editor.view.video.WinkPlayerContainerView;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.dengta.WinkDengtaReportConstant;
import com.tencent.videocut.model.ResourceModel;
import com.tencent.videocut.model.SizeF;
import java.io.File;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.editor.avatar.WinkDynamicAvatarFragment$genApngAndUpload$1", f = "WinkDynamicAvatarFragment.kt", i = {0, 1, 1, 2, 2}, l = {602, 603, 605}, m = "invokeSuspend", n = {"cropStaticFrameDeferred", "staticFramePath", "apngPath", "apngPath", "uploadStartTime"}, s = {"L$0", "L$0", "L$1", "L$0", "J$0"})
/* loaded from: classes21.dex */
public final class WinkDynamicAvatarFragment$genApngAndUpload$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ WinkDynamicAvatarFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkDynamicAvatarFragment$genApngAndUpload$1(WinkDynamicAvatarFragment winkDynamicAvatarFragment, Continuation<? super WinkDynamicAvatarFragment$genApngAndUpload$1> continuation) {
        super(2, continuation);
        this.this$0 = winkDynamicAvatarFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        WinkDynamicAvatarFragment$genApngAndUpload$1 winkDynamicAvatarFragment$genApngAndUpload$1 = new WinkDynamicAvatarFragment$genApngAndUpload$1(this.this$0, continuation);
        winkDynamicAvatarFragment$genApngAndUpload$1.L$0 = obj;
        return winkDynamicAvatarFragment$genApngAndUpload$1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x03ba A[Catch: all -> 0x006d, TryCatch #0 {all -> 0x006d, blocks: (B:8:0x0025, B:10:0x03b2, B:12:0x03ba, B:13:0x03e9, B:16:0x03f4, B:19:0x0452, B:29:0x0047, B:32:0x0379, B:35:0x038a, B:41:0x005c, B:43:0x035c, B:102:0x030c), top: B:2:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x03f1  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x044f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0451  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x03f3  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x03b0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x03b1  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0389  */
    /* JADX WARN: Type inference failed for: r0v49 */
    /* JADX WARN: Type inference failed for: r0v50 */
    /* JADX WARN: Type inference failed for: r0v57 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        SizeF sizeF;
        Object obj2;
        String str;
        Object obj3;
        String str2;
        Deferred async$default;
        Deferred async$default2;
        Object await;
        Object obj4;
        String str3;
        String str4;
        Object await2;
        String str5;
        long elapsedRealtime;
        WinkDynamicAvatarUploader mi5;
        String str6;
        String feedId;
        String ri5;
        long si5;
        ?? r06;
        Object x16;
        String str7;
        boolean booleanValue;
        boolean z16;
        Map mapOf;
        boolean z17;
        WinkDynamicAvatarFragment$genApngAndUpload$1 winkDynamicAvatarFragment$genApngAndUpload$1 = this;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = winkDynamicAvatarFragment$genApngAndUpload$1.label;
        boolean z18 = true;
        try {
        } catch (Throwable th5) {
            if (th5 instanceof CancellationException) {
                w53.b.f(winkDynamicAvatarFragment$genApngAndUpload$1.this$0.getTAG(), "genApngAndUpload canceled");
                return Unit.INSTANCE;
            }
            w53.b.d(winkDynamicAvatarFragment$genApngAndUpload$1.this$0.getTAG(), "genApngAndUpload fail", th5);
            winkDynamicAvatarFragment$genApngAndUpload$1.this$0.ji(th5);
        }
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        long j3 = winkDynamicAvatarFragment$genApngAndUpload$1.J$0;
                        str7 = (String) winkDynamicAvatarFragment$genApngAndUpload$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        obj2 = WinkDaTongReportConstant.PageId.PG_XSJ_LIVE_AVATAR_EDIT_PAGE;
                        r06 = 1;
                        str = "xsj_custom_pgid";
                        obj3 = WinkDaTongReportConstant.ElementId.EM_XSJ_SET_LIVE_AVATAR_SUCCESS;
                        str2 = "xsj_eid";
                        elapsedRealtime = j3;
                        x16 = obj;
                        booleanValue = ((Boolean) x16).booleanValue();
                        if (booleanValue) {
                            com.tencent.mobileqq.wink.report.e eVar = com.tencent.mobileqq.wink.report.e.f326265a;
                            Map<String, ?> buildElementParams = WinkDTParamBuilder.buildElementParams();
                            Object obj5 = obj3;
                            String str8 = str2;
                            buildElementParams.put(str8, obj5);
                            Object obj6 = obj2;
                            String str9 = str;
                            buildElementParams.put(str9, obj6);
                            Unit unit = Unit.INSTANCE;
                            Map<String, ?> buildElementParams2 = WinkDTParamBuilder.buildElementParams();
                            buildElementParams2.put(str8, obj5);
                            buildElementParams2.put(str9, obj6);
                            eVar.q("ev_xsj_abnormal_imp", null, WinkDaTongReportConstant.ElementId.EM_XSJ_SET_LIVE_AVATAR_SUCCESS, buildElementParams, buildElementParams2);
                        }
                        String tag = winkDynamicAvatarFragment$genApngAndUpload$1.this$0.getTAG();
                        if (!booleanValue) {
                            z16 = r06;
                        } else {
                            z16 = false;
                        }
                        w53.b.f(tag, "WinkDynamicAvatarUploader result = " + z16);
                        com.tencent.mobileqq.wink.report.e eVar2 = com.tencent.mobileqq.wink.report.e.f326265a;
                        Pair[] pairArr = new Pair[2];
                        pairArr[0] = TuplesKt.to(WinkDengtaReportConstant.Params.WEZONE_DYNAMIC_AVATAR_COST_TIME, String.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
                        pairArr[r06] = TuplesKt.to(WinkDengtaReportConstant.Params.WEZONE_DYNAMIC_AVATAR_APNG_SIZE, String.valueOf(new File(str7).length()));
                        mapOf = MapsKt__MapsKt.mapOf(pairArr);
                        com.tencent.mobileqq.wink.report.e.o(eVar2, WinkDengtaReportConstant.Action.WEZONE_DYNAMIC_AVATAR_UPLOAD_COST, mapOf, false, 4, null);
                        String tag2 = winkDynamicAvatarFragment$genApngAndUpload$1.this$0.getTAG();
                        if (!booleanValue) {
                            z17 = r06;
                        } else {
                            z17 = false;
                        }
                        w53.b.f(tag2, "genApngAndUpload result = " + z17);
                        winkDynamicAvatarFragment$genApngAndUpload$1.this$0.gi();
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                str4 = (String) winkDynamicAvatarFragment$genApngAndUpload$1.L$1;
                str3 = (String) winkDynamicAvatarFragment$genApngAndUpload$1.L$0;
                ResultKt.throwOnFailure(obj);
                obj2 = WinkDaTongReportConstant.PageId.PG_XSJ_LIVE_AVATAR_EDIT_PAGE;
                str = "xsj_custom_pgid";
                obj3 = WinkDaTongReportConstant.ElementId.EM_XSJ_SET_LIVE_AVATAR_SUCCESS;
                str2 = "xsj_eid";
                obj4 = coroutine_suspended;
                await2 = obj;
                String str10 = str4;
                str5 = (String) await2;
                elapsedRealtime = SystemClock.elapsedRealtime();
                mi5 = winkDynamicAvatarFragment$genApngAndUpload$1.this$0.mi();
                if (str5 != null) {
                    str6 = str3;
                } else {
                    str6 = str5;
                }
                feedId = winkDynamicAvatarFragment$genApngAndUpload$1.this$0.getFeedId();
                ri5 = winkDynamicAvatarFragment$genApngAndUpload$1.this$0.ri();
                si5 = winkDynamicAvatarFragment$genApngAndUpload$1.this$0.si();
                winkDynamicAvatarFragment$genApngAndUpload$1.L$0 = str10;
                winkDynamicAvatarFragment$genApngAndUpload$1.L$1 = null;
                winkDynamicAvatarFragment$genApngAndUpload$1.J$0 = elapsedRealtime;
                winkDynamicAvatarFragment$genApngAndUpload$1.label = 3;
                r06 = z18;
                x16 = mi5.x(str6, str10, feedId, ri5, si5, this);
                if (x16 != obj4) {
                    return obj4;
                }
                str7 = str10;
                booleanValue = ((Boolean) x16).booleanValue();
                if (booleanValue) {
                }
                String tag3 = winkDynamicAvatarFragment$genApngAndUpload$1.this$0.getTAG();
                if (!booleanValue) {
                }
                w53.b.f(tag3, "WinkDynamicAvatarUploader result = " + z16);
                com.tencent.mobileqq.wink.report.e eVar22 = com.tencent.mobileqq.wink.report.e.f326265a;
                Pair[] pairArr2 = new Pair[2];
                pairArr2[0] = TuplesKt.to(WinkDengtaReportConstant.Params.WEZONE_DYNAMIC_AVATAR_COST_TIME, String.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
                pairArr2[r06] = TuplesKt.to(WinkDengtaReportConstant.Params.WEZONE_DYNAMIC_AVATAR_APNG_SIZE, String.valueOf(new File(str7).length()));
                mapOf = MapsKt__MapsKt.mapOf(pairArr2);
                com.tencent.mobileqq.wink.report.e.o(eVar22, WinkDengtaReportConstant.Action.WEZONE_DYNAMIC_AVATAR_UPLOAD_COST, mapOf, false, 4, null);
                String tag22 = winkDynamicAvatarFragment$genApngAndUpload$1.this$0.getTAG();
                if (!booleanValue) {
                }
                w53.b.f(tag22, "genApngAndUpload result = " + z17);
                winkDynamicAvatarFragment$genApngAndUpload$1.this$0.gi();
                return Unit.INSTANCE;
            }
            Deferred deferred = (Deferred) winkDynamicAvatarFragment$genApngAndUpload$1.L$0;
            ResultKt.throwOnFailure(obj);
            obj2 = WinkDaTongReportConstant.PageId.PG_XSJ_LIVE_AVATAR_EDIT_PAGE;
            async$default2 = deferred;
            str = "xsj_custom_pgid";
            obj3 = WinkDaTongReportConstant.ElementId.EM_XSJ_SET_LIVE_AVATAR_SUCCESS;
            str2 = "xsj_eid";
            obj4 = coroutine_suspended;
            await = obj;
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) winkDynamicAvatarFragment$genApngAndUpload$1.L$0;
            winkDynamicAvatarFragment$genApngAndUpload$1.this$0.Qi();
            WinkSegClipView.SegClipModel segClipModel = winkDynamicAvatarFragment$genApngAndUpload$1.this$0.segClipData;
            if (segClipModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("segClipData");
                segClipModel = null;
            }
            ResourceModel resourceModel = segClipModel.getMediaClip().resource;
            if (resourceModel != null) {
                sizeF = resourceModel.size;
            } else {
                sizeF = null;
            }
            if (sizeF != null && sizeF.width > 0.0f && sizeF.height > 0.0f) {
                WinkPlayerContainerView winkPlayerContainerView = winkDynamicAvatarFragment$genApngAndUpload$1.this$0.playerContainer;
                if (winkPlayerContainerView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("playerContainer");
                    winkPlayerContainerView = null;
                }
                WinkDynamicAvatarFragment winkDynamicAvatarFragment = winkDynamicAvatarFragment$genApngAndUpload$1.this$0;
                String tag4 = winkDynamicAvatarFragment.getTAG();
                int left = winkPlayerContainerView.getLeft();
                int top = winkPlayerContainerView.getTop();
                int right = winkPlayerContainerView.getRight();
                obj2 = WinkDaTongReportConstant.PageId.PG_XSJ_LIVE_AVATAR_EDIT_PAGE;
                int bottom = winkPlayerContainerView.getBottom();
                str = "xsj_custom_pgid";
                float translationX = winkPlayerContainerView.getTranslationX();
                obj3 = WinkDaTongReportConstant.ElementId.EM_XSJ_SET_LIVE_AVATAR_SUCCESS;
                str2 = "xsj_eid";
                SizeF sizeF2 = sizeF;
                w53.b.f(tag4, "calculate outputRect:playerContainer: " + left + " " + top + " " + right + " " + bottom + " " + translationX + " " + winkPlayerContainerView.getTranslationY() + " " + winkPlayerContainerView.getMeasuredWidth() + " " + winkPlayerContainerView.getMeasuredHeight() + " hole: " + winkDynamicAvatarFragment.vi().getLeft() + " " + winkDynamicAvatarFragment.vi().getTop() + " " + winkDynamicAvatarFragment.vi().getRight() + " " + winkDynamicAvatarFragment.vi().getBottom() + " " + winkDynamicAvatarFragment.vi().getMeasuredWidth() + " " + winkDynamicAvatarFragment.vi().getMeasuredHeight() + " videoSize: " + sizeF.width + " " + sizeF.height);
                winkDynamicAvatarFragment$genApngAndUpload$1 = this;
                WinkPlayerContainerView winkPlayerContainerView2 = winkDynamicAvatarFragment$genApngAndUpload$1.this$0.playerContainer;
                if (winkPlayerContainerView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("playerContainer");
                    winkPlayerContainerView2 = null;
                }
                float left2 = winkPlayerContainerView2.getLeft();
                WinkPlayerContainerView winkPlayerContainerView3 = winkDynamicAvatarFragment$genApngAndUpload$1.this$0.playerContainer;
                if (winkPlayerContainerView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("playerContainer");
                    winkPlayerContainerView3 = null;
                }
                float abs = Math.abs((left2 + winkPlayerContainerView3.getTranslationX()) - winkDynamicAvatarFragment$genApngAndUpload$1.this$0.vi().getLeft());
                WinkPlayerContainerView winkPlayerContainerView4 = winkDynamicAvatarFragment$genApngAndUpload$1.this$0.playerContainer;
                if (winkPlayerContainerView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("playerContainer");
                    winkPlayerContainerView4 = null;
                }
                float measuredWidth = abs / winkPlayerContainerView4.getMeasuredWidth();
                WinkPlayerContainerView winkPlayerContainerView5 = winkDynamicAvatarFragment$genApngAndUpload$1.this$0.playerContainer;
                if (winkPlayerContainerView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("playerContainer");
                    winkPlayerContainerView5 = null;
                }
                float top2 = winkPlayerContainerView5.getTop();
                WinkPlayerContainerView winkPlayerContainerView6 = winkDynamicAvatarFragment$genApngAndUpload$1.this$0.playerContainer;
                if (winkPlayerContainerView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("playerContainer");
                    winkPlayerContainerView6 = null;
                }
                float abs2 = Math.abs((top2 + winkPlayerContainerView6.getTranslationY()) - winkDynamicAvatarFragment$genApngAndUpload$1.this$0.vi().getTop());
                WinkPlayerContainerView winkPlayerContainerView7 = winkDynamicAvatarFragment$genApngAndUpload$1.this$0.playerContainer;
                if (winkPlayerContainerView7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("playerContainer");
                    winkPlayerContainerView7 = null;
                }
                float measuredHeight = abs2 / winkPlayerContainerView7.getMeasuredHeight();
                WinkPlayerContainerView winkPlayerContainerView8 = winkDynamicAvatarFragment$genApngAndUpload$1.this$0.playerContainer;
                if (winkPlayerContainerView8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("playerContainer");
                    winkPlayerContainerView8 = null;
                }
                float left3 = winkPlayerContainerView8.getLeft();
                WinkPlayerContainerView winkPlayerContainerView9 = winkDynamicAvatarFragment$genApngAndUpload$1.this$0.playerContainer;
                if (winkPlayerContainerView9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("playerContainer");
                    winkPlayerContainerView9 = null;
                }
                float abs3 = Math.abs((left3 + winkPlayerContainerView9.getTranslationX()) - winkDynamicAvatarFragment$genApngAndUpload$1.this$0.vi().getLeft()) + winkDynamicAvatarFragment$genApngAndUpload$1.this$0.vi().getMeasuredWidth();
                WinkPlayerContainerView winkPlayerContainerView10 = winkDynamicAvatarFragment$genApngAndUpload$1.this$0.playerContainer;
                if (winkPlayerContainerView10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("playerContainer");
                    winkPlayerContainerView10 = null;
                }
                float measuredWidth2 = abs3 / winkPlayerContainerView10.getMeasuredWidth();
                WinkPlayerContainerView winkPlayerContainerView11 = winkDynamicAvatarFragment$genApngAndUpload$1.this$0.playerContainer;
                if (winkPlayerContainerView11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("playerContainer");
                    winkPlayerContainerView11 = null;
                }
                float top3 = winkPlayerContainerView11.getTop();
                WinkPlayerContainerView winkPlayerContainerView12 = winkDynamicAvatarFragment$genApngAndUpload$1.this$0.playerContainer;
                if (winkPlayerContainerView12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("playerContainer");
                    winkPlayerContainerView12 = null;
                }
                float abs4 = Math.abs((top3 + winkPlayerContainerView12.getTranslationY()) - winkDynamicAvatarFragment$genApngAndUpload$1.this$0.vi().getTop()) + winkDynamicAvatarFragment$genApngAndUpload$1.this$0.vi().getMeasuredHeight();
                WinkPlayerContainerView winkPlayerContainerView13 = winkDynamicAvatarFragment$genApngAndUpload$1.this$0.playerContainer;
                if (winkPlayerContainerView13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("playerContainer");
                    winkPlayerContainerView13 = null;
                }
                float f16 = sizeF2.width;
                float f17 = sizeF2.height;
                Rect rect = new Rect((int) (measuredWidth * f16), (int) (measuredHeight * f17), (int) (measuredWidth2 * f16), (int) ((abs4 / winkPlayerContainerView13.getMeasuredHeight()) * f17));
                float width = rect.left + rect.width();
                float f18 = sizeF2.width;
                if (width > f18) {
                    rect.left = 0;
                    rect.right = (int) f18;
                }
                float height = rect.top + rect.height();
                float f19 = sizeF2.height;
                if (height > f19) {
                    rect.top = 0;
                    rect.bottom = (int) f19;
                }
                WinkCoroutineScopes winkCoroutineScopes = WinkCoroutineScopes.f317652a;
                async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, winkCoroutineScopes.b(), null, new WinkDynamicAvatarFragment$genApngAndUpload$1$genApngDeferred$1(winkDynamicAvatarFragment$genApngAndUpload$1.this$0, sizeF2, rect, resourceModel, null), 2, null);
                async$default2 = BuildersKt__Builders_commonKt.async$default(coroutineScope, winkCoroutineScopes.b(), null, new WinkDynamicAvatarFragment$genApngAndUpload$1$cropStaticFrameDeferred$1(winkDynamicAvatarFragment$genApngAndUpload$1.this$0, rect, null), 2, null);
                winkDynamicAvatarFragment$genApngAndUpload$1.L$0 = async$default2;
                z18 = true;
                winkDynamicAvatarFragment$genApngAndUpload$1.label = 1;
                await = async$default.await(winkDynamicAvatarFragment$genApngAndUpload$1);
                obj4 = coroutine_suspended;
                if (await == obj4) {
                    return obj4;
                }
            } else {
                return Unit.INSTANCE;
            }
        }
        Pair pair = (Pair) await;
        str3 = (String) pair.component1();
        str4 = (String) pair.component2();
        winkDynamicAvatarFragment$genApngAndUpload$1.L$0 = str3;
        winkDynamicAvatarFragment$genApngAndUpload$1.L$1 = str4;
        winkDynamicAvatarFragment$genApngAndUpload$1.label = 2;
        await2 = async$default2.await(winkDynamicAvatarFragment$genApngAndUpload$1);
        if (await2 == obj4) {
            return obj4;
        }
        String str102 = str4;
        str5 = (String) await2;
        elapsedRealtime = SystemClock.elapsedRealtime();
        mi5 = winkDynamicAvatarFragment$genApngAndUpload$1.this$0.mi();
        if (str5 != null) {
        }
        feedId = winkDynamicAvatarFragment$genApngAndUpload$1.this$0.getFeedId();
        ri5 = winkDynamicAvatarFragment$genApngAndUpload$1.this$0.ri();
        si5 = winkDynamicAvatarFragment$genApngAndUpload$1.this$0.si();
        winkDynamicAvatarFragment$genApngAndUpload$1.L$0 = str102;
        winkDynamicAvatarFragment$genApngAndUpload$1.L$1 = null;
        winkDynamicAvatarFragment$genApngAndUpload$1.J$0 = elapsedRealtime;
        winkDynamicAvatarFragment$genApngAndUpload$1.label = 3;
        r06 = z18;
        x16 = mi5.x(str6, str102, feedId, ri5, si5, this);
        if (x16 != obj4) {
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkDynamicAvatarFragment$genApngAndUpload$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
