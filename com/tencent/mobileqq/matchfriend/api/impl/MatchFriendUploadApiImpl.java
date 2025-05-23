package com.tencent.mobileqq.matchfriend.api.impl;

import com.tencent.mobileqq.matchfriend.api.IMatchFriendUploadApi;
import com.tencent.mobileqq.matchfriend.reborn.publish.upload.PicUploadResult;
import com.tencent.mobileqq.matchfriend.reborn.publish.upload.SquareFeedPicUploader;
import com.tencent.mobileqq.troop.announcement.api.ITroopAnnouncementHelperApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J-\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/api/impl/MatchFriendUploadApiImpl;", "Lcom/tencent/mobileqq/matchfriend/api/IMatchFriendUploadApi;", "()V", "uploadPics", "", "", "paths", ITroopAnnouncementHelperApi.CONTROL_INFO_COMPRESS, "", "(Ljava/util/List;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MatchFriendUploadApiImpl implements IMatchFriendUploadApi {
    /* JADX WARN: Removed duplicated region for block: B:13:0x0059 A[LOOP:0: B:11:0x0053->B:13:0x0059, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendUploadApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object uploadPics(List<String> list, boolean z16, Continuation<? super List<String>> continuation) {
        MatchFriendUploadApiImpl$uploadPics$1 matchFriendUploadApiImpl$uploadPics$1;
        Object coroutine_suspended;
        int i3;
        int collectionSizeOrDefault;
        Iterator it;
        if (continuation instanceof MatchFriendUploadApiImpl$uploadPics$1) {
            matchFriendUploadApiImpl$uploadPics$1 = (MatchFriendUploadApiImpl$uploadPics$1) continuation;
            int i16 = matchFriendUploadApiImpl$uploadPics$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                matchFriendUploadApiImpl$uploadPics$1.label = i16 - Integer.MIN_VALUE;
                Object obj = matchFriendUploadApiImpl$uploadPics$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = matchFriendUploadApiImpl$uploadPics$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    SquareFeedPicUploader squareFeedPicUploader = SquareFeedPicUploader.f245352a;
                    matchFriendUploadApiImpl$uploadPics$1.label = 1;
                    obj = squareFeedPicUploader.l(list, z16, matchFriendUploadApiImpl$uploadPics$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                List list2 = (List) obj;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(((PicUploadResult) it.next()).getUrl());
                }
                return arrayList;
            }
        }
        matchFriendUploadApiImpl$uploadPics$1 = new MatchFriendUploadApiImpl$uploadPics$1(this, continuation);
        Object obj2 = matchFriendUploadApiImpl$uploadPics$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = matchFriendUploadApiImpl$uploadPics$1.label;
        if (i3 != 0) {
        }
        List list22 = (List) obj2;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list22, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        it = list22.iterator();
        while (it.hasNext()) {
        }
        return arrayList2;
    }
}
