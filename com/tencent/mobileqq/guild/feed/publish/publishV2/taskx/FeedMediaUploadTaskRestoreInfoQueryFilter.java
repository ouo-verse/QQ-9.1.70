package com.tencent.mobileqq.guild.feed.publish.publishV2.taskx;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.guild.feed.publish.bean.GuildMediaProgressState;
import com.tencent.mobileqq.guild.feed.publish.bean.GuildTaskProgressState;
import com.tencent.qphone.base.util.QLog;
import ij1.GuildMediaUploadTaskInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJX\u0010\u000e\u001a\u001a\u0012\b\u0012\u00060\u000bj\u0002`\f0\nj\f\u0012\b\u0012\u00060\u000bj\u0002`\f`\r2\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00070\u00022\u0006\u0010\t\u001a\u00020\u0003H\u0002J\"\u0010\u0012\u001a\u00020\u00112\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u000e\u0010\u0010\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007H\u0002JA\u0010\u0014\u001a\f\u0012\b\u0012\u00060\u000bj\u0002`\f0\u00132\u0006\u0010\t\u001a\u00020\u00032\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00070\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0018\u001a\f\u0012\b\u0012\u00060\u000bj\u0002`\f0\u00132\u0006\u0010\u0017\u001a\u00020\u0016R\u0014\u0010\u001a\u001a\u00020\u00038\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/publish/publishV2/taskx/FeedMediaUploadTaskRestoreInfoQueryFilter;", "", "", "", "Lcom/tencent/mobileqq/guild/feed/publish/bean/GuildMediaProgressState;", "metaMap", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "Lcom/tencent/mobileqq/guild/feed/publish/api/QQAlbumMediumModel;", "mediaSelected", "traceId", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/guild/feed/publish/publishV2/taskx/j;", "Lcom/tencent/mobileqq/guild/feed/publish/api/MediumUploadRestoreInfo;", "Lkotlin/collections/ArrayList;", "a", PublicAccountMessageUtilImpl.META_NAME, "albumModel", "Lcom/tencent/mobileqq/guild/data/g;", "c", "", "d", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/guild/feed/publish/bean/GuildTaskProgressState;", "taskState", "b", "Ljava/lang/String;", "logTag", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedMediaUploadTaskRestoreInfoQueryFilter {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String logTag = "FeedMediaUploadTaskRestoreInfoQueryFilter";

    /* JADX WARN: Removed duplicated region for block: B:43:0x0136 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x009a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final ArrayList<MediumUploadStateRestoreInfo> a(Map<String, ? extends GuildMediaProgressState> metaMap, Map<String, ? extends LocalMediaInfo> mediaSelected, String traceId) {
        ArrayList arrayList;
        String joinToString$default;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        MediumUploadStateRestoreInfo mediumUploadStateRestoreInfo;
        String str;
        boolean z26;
        Map minus;
        boolean z27;
        Integer num = null;
        if (metaMap.size() < mediaSelected.size()) {
            minus = MapsKt__MapsKt.minus((Map) mediaSelected, (Iterable) metaMap.keySet());
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : minus.entrySet()) {
                if (((LocalMediaInfo) entry.getValue()) != null) {
                    z27 = true;
                } else {
                    z27 = false;
                }
                if (z27) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            arrayList = new ArrayList(linkedHashMap.size());
            for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                arrayList.add(new MediumUploadStateRestoreInfo((String) entry2.getKey(), false, true, false, c(null, (LocalMediaInfo) entry2.getValue()), null, null));
            }
        } else {
            arrayList = null;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry<String, ? extends GuildMediaProgressState> entry3 : metaMap.entrySet()) {
            String key = entry3.getKey();
            GuildMediaProgressState value = entry3.getValue();
            GuildMediaUploadTaskInfo a16 = k.f223157a.a(value);
            String taskId = value.getTaskId();
            if (taskId == null) {
                taskId = "";
            }
            LocalMediaInfo localMediaInfo = mediaSelected.get(taskId);
            String path = value.getPath();
            if (path != null && path.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                if (localMediaInfo != null) {
                    str = localMediaInfo.path;
                } else {
                    str = null;
                }
                if (str != null && str.length() != 0) {
                    z26 = false;
                } else {
                    z26 = true;
                }
                if (z26) {
                    mediumUploadStateRestoreInfo = null;
                    if (mediumUploadStateRestoreInfo == null) {
                        arrayList2.add(mediumUploadStateRestoreInfo);
                    }
                }
            }
            if (a16.e() && a16.G()) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!a16.isCompleted() && a16.isActive()) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (!a16.j() && ((z17 || z18) && (a16.isActive() || a16.isCompleted()))) {
                z19 = false;
            } else {
                z19 = true;
            }
            mediumUploadStateRestoreInfo = new MediumUploadStateRestoreInfo(key, z17, z19, z18, c(value, localMediaInfo), a16, value);
            if (mediumUploadStateRestoreInfo == null) {
            }
        }
        if (QLog.isDevelopLevel()) {
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(mediaSelected.entrySet(), null, "[", "]", 0, null, new Function1<Map.Entry<? extends String, ? extends LocalMediaInfo>, CharSequence>() { // from class: com.tencent.mobileqq.guild.feed.publish.publishV2.taskx.FeedMediaUploadTaskRestoreInfoQueryFilter$filterRestoreInfoList$mediaSelectedString$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ CharSequence invoke(Map.Entry<? extends String, ? extends LocalMediaInfo> entry4) {
                    return invoke2((Map.Entry<String, ? extends LocalMediaInfo>) entry4);
                }

                @NotNull
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final CharSequence invoke2(@NotNull Map.Entry<String, ? extends LocalMediaInfo> it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    String key2 = it.getKey();
                    LocalMediaInfo value2 = it.getValue();
                    return ((Object) key2) + ":" + (value2 != null ? value2.path : null);
                }
            }, 25, null);
            QLog.d(this.logTag, 4, "[queryAndFilterRestoreInfoList](" + traceId + "): input=" + joinToString$default);
        }
        String str2 = this.logTag;
        int size = mediaSelected.size();
        int size2 = metaMap.size();
        if (arrayList != null) {
            num = Integer.valueOf(arrayList.size());
        }
        QLog.i(str2, 1, "[queryAndFilterRestoreInfoList](" + traceId + "): input.size=" + size + ", metaMap.size=" + size2 + " restoreInfoListWhichReferAlbumModelOnly.size=" + num + ",  restoreInfoListWhichReferMeta.size=" + arrayList2.size());
        ArrayList<MediumUploadStateRestoreInfo> arrayList3 = new ArrayList<>(arrayList2);
        if (arrayList != null) {
            arrayList3.addAll(arrayList);
        }
        return arrayList3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001b, code lost:
    
        if (r6 == null) goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final com.tencent.mobileqq.guild.data.g c(GuildMediaProgressState meta, LocalMediaInfo albumModel) {
        String str;
        String str2;
        long j3;
        String str3;
        long j16;
        int i3;
        int i16;
        String c16;
        String str4;
        int i17;
        long j17;
        long j18;
        int i18;
        int i19;
        com.tencent.mobileqq.guild.data.g gVar;
        boolean z16;
        boolean z17;
        String str5 = null;
        if (albumModel != null && (str = albumModel.path) != null) {
            if (str.length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                str = null;
            }
        }
        if (meta != null) {
            str = meta.getPath();
        } else {
            str = null;
        }
        if (str == null) {
            str2 = "";
            if (albumModel == null) {
                j3 = albumModel._id;
            } else {
                j3 = 0;
            }
            if (albumModel != null) {
                str5 = albumModel.thumbnailPath;
            }
            if (str5 != null) {
                str3 = "";
            } else {
                str3 = str5;
            }
            if (albumModel == null) {
                j16 = albumModel.fileSize;
            } else {
                j16 = 0;
            }
            if (albumModel == null) {
                i3 = albumModel.mediaWidth;
            } else {
                i3 = 0;
            }
            if (albumModel == null) {
                i16 = albumModel.mediaHeight;
            } else {
                i16 = 0;
            }
            if ((albumModel != null || (c16 = albumModel.mMimeType) == null) && (c16 = com.tencent.mobileqq.guild.util.i.f235563a.c(str2)) == null) {
                str4 = "";
            } else {
                str4 = c16;
            }
            if (albumModel == null) {
                i17 = albumModel.rotation;
            } else {
                i17 = 0;
            }
            if (albumModel == null) {
                j17 = albumModel.mDuration;
            } else {
                j17 = 0;
            }
            if (albumModel == null) {
                j18 = albumModel.mediaOriginBitrate;
            } else {
                j18 = 0;
            }
            if (albumModel == null) {
                i18 = albumModel.mediaOriginWidth;
            } else {
                i18 = 0;
            }
            if (albumModel == null) {
                i19 = albumModel.mediaOriginHeight;
            } else {
                i19 = 0;
            }
            gVar = new com.tencent.mobileqq.guild.data.g(j3, str2, j16, str3, i3, i16, str4, i17, j17, false, i18, i19, j18, 512, null);
            if (gVar.getPath().length() != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                QLog.e(this.logTag, 1, "[makeGuildLocalMediaInfo]: path is empty meta:" + meta + " albumModel" + albumModel);
            }
            return gVar;
        }
        str2 = str;
        if (albumModel == null) {
        }
        if (albumModel != null) {
        }
        if (str5 != null) {
        }
        if (albumModel == null) {
        }
        if (albumModel == null) {
        }
        if (albumModel == null) {
        }
        if (albumModel != null) {
        }
        str4 = "";
        if (albumModel == null) {
        }
        if (albumModel == null) {
        }
        if (albumModel == null) {
        }
        if (albumModel == null) {
        }
        if (albumModel == null) {
        }
        gVar = new com.tencent.mobileqq.guild.data.g(j3, str2, j16, str3, i3, i16, str4, i17, j17, false, i18, i19, j18, 512, null);
        if (gVar.getPath().length() != 0) {
        }
        if (z16) {
        }
        return gVar;
    }

    @NotNull
    public final List<MediumUploadStateRestoreInfo> b(@NotNull GuildTaskProgressState taskState) {
        boolean z16;
        int collectionSizeOrDefault;
        int mapCapacity;
        int coerceAtLeast;
        int collectionSizeOrDefault2;
        int mapCapacity2;
        int coerceAtLeast2;
        List<MediumUploadStateRestoreInfo> emptyList;
        Intrinsics.checkNotNullParameter(taskState, "taskState");
        List<GuildMediaProgressState> mediaProgressStates = taskState.getMediaProgressStates();
        if (mediaProgressStates != null && !mediaProgressStates.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        List<GuildMediaProgressState> mediaProgressStates2 = taskState.getMediaProgressStates();
        Intrinsics.checkNotNullExpressionValue(mediaProgressStates2, "mediaProgressStates");
        List<GuildMediaProgressState> list = mediaProgressStates2;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        Map<String, ? extends GuildMediaProgressState> linkedHashMap = new LinkedHashMap<>(coerceAtLeast);
        Iterator<T> it = list.iterator();
        while (true) {
            String str = "";
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            String taskId = ((GuildMediaProgressState) next).getTaskId();
            if (taskId != null) {
                Intrinsics.checkNotNullExpressionValue(taskId, "it.taskId?:\"\"");
                str = taskId;
            }
            linkedHashMap.put(str, next);
        }
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        mapCapacity2 = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault2);
        coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(mapCapacity2, 16);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(coerceAtLeast2);
        Iterator<T> it5 = list.iterator();
        while (it5.hasNext()) {
            String taskId2 = ((GuildMediaProgressState) it5.next()).getTaskId();
            if (taskId2 == null) {
                taskId2 = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(taskId2, "it.taskId?:\"\"");
            }
            Pair pair = TuplesKt.to(taskId2, null);
            linkedHashMap2.put(pair.getFirst(), pair.getSecond());
        }
        String mainTaskId = taskState.getMainTaskId();
        Intrinsics.checkNotNullExpressionValue(mainTaskId, "taskState.mainTaskId");
        return a(linkedHashMap, linkedHashMap2, mainTaskId);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object d(@NotNull String str, @NotNull Map<String, ? extends LocalMediaInfo> map, @NotNull Continuation<? super List<MediumUploadStateRestoreInfo>> continuation) {
        FeedMediaUploadTaskRestoreInfoQueryFilter$queryAndFilterRestoreInfoList$1 feedMediaUploadTaskRestoreInfoQueryFilter$queryAndFilterRestoreInfoList$1;
        Object coroutine_suspended;
        int i3;
        FeedMediaUploadTaskRestoreInfoQueryFilter feedMediaUploadTaskRestoreInfoQueryFilter;
        List emptyList;
        int collectionSizeOrDefault;
        int mapCapacity;
        int coerceAtLeast;
        boolean z16;
        boolean z17;
        if (continuation instanceof FeedMediaUploadTaskRestoreInfoQueryFilter$queryAndFilterRestoreInfoList$1) {
            feedMediaUploadTaskRestoreInfoQueryFilter$queryAndFilterRestoreInfoList$1 = (FeedMediaUploadTaskRestoreInfoQueryFilter$queryAndFilterRestoreInfoList$1) continuation;
            int i16 = feedMediaUploadTaskRestoreInfoQueryFilter$queryAndFilterRestoreInfoList$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                feedMediaUploadTaskRestoreInfoQueryFilter$queryAndFilterRestoreInfoList$1.label = i16 - Integer.MIN_VALUE;
                Object obj = feedMediaUploadTaskRestoreInfoQueryFilter$queryAndFilterRestoreInfoList$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = feedMediaUploadTaskRestoreInfoQueryFilter$queryAndFilterRestoreInfoList$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        map = (Map) feedMediaUploadTaskRestoreInfoQueryFilter$queryAndFilterRestoreInfoList$1.L$2;
                        str = (String) feedMediaUploadTaskRestoreInfoQueryFilter$queryAndFilterRestoreInfoList$1.L$1;
                        feedMediaUploadTaskRestoreInfoQueryFilter = (FeedMediaUploadTaskRestoreInfoQueryFilter) feedMediaUploadTaskRestoreInfoQueryFilter$queryAndFilterRestoreInfoList$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    if (map.isEmpty()) {
                        emptyList = CollectionsKt__CollectionsKt.emptyList();
                        return emptyList;
                    }
                    in1.a a16 = in1.b.a();
                    Set<String> keySet = map.keySet();
                    feedMediaUploadTaskRestoreInfoQueryFilter$queryAndFilterRestoreInfoList$1.L$0 = this;
                    feedMediaUploadTaskRestoreInfoQueryFilter$queryAndFilterRestoreInfoList$1.L$1 = str;
                    feedMediaUploadTaskRestoreInfoQueryFilter$queryAndFilterRestoreInfoList$1.L$2 = map;
                    feedMediaUploadTaskRestoreInfoQueryFilter$queryAndFilterRestoreInfoList$1.label = 1;
                    obj = a16.a(keySet, feedMediaUploadTaskRestoreInfoQueryFilter$queryAndFilterRestoreInfoList$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    feedMediaUploadTaskRestoreInfoQueryFilter = this;
                }
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : (Iterable) obj) {
                    GuildMediaProgressState guildMediaProgressState = (GuildMediaProgressState) obj2;
                    String taskId = guildMediaProgressState.getTaskId();
                    boolean z18 = false;
                    if (taskId != null && taskId.length() != 0) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    if (!z16) {
                        String path = guildMediaProgressState.getPath();
                        if (path != null && path.length() != 0) {
                            z17 = false;
                        } else {
                            z17 = true;
                        }
                        if (!z17) {
                            z18 = true;
                        }
                    }
                    if (z18) {
                        arrayList.add(obj2);
                    }
                }
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
                mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
                LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
                for (Object obj3 : arrayList) {
                    String taskId2 = ((GuildMediaProgressState) obj3).getTaskId();
                    if (taskId2 == null) {
                        taskId2 = "";
                    } else {
                        Intrinsics.checkNotNullExpressionValue(taskId2, "it.taskId ?: \"\"");
                    }
                    linkedHashMap.put(taskId2, obj3);
                }
                return feedMediaUploadTaskRestoreInfoQueryFilter.a(linkedHashMap, map, str);
            }
        }
        feedMediaUploadTaskRestoreInfoQueryFilter$queryAndFilterRestoreInfoList$1 = new FeedMediaUploadTaskRestoreInfoQueryFilter$queryAndFilterRestoreInfoList$1(this, continuation);
        Object obj4 = feedMediaUploadTaskRestoreInfoQueryFilter$queryAndFilterRestoreInfoList$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = feedMediaUploadTaskRestoreInfoQueryFilter$queryAndFilterRestoreInfoList$1.label;
        if (i3 == 0) {
        }
        ArrayList arrayList2 = new ArrayList();
        while (r10.hasNext()) {
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(coerceAtLeast);
        while (r10.hasNext()) {
        }
        return feedMediaUploadTaskRestoreInfoQueryFilter.a(linkedHashMap2, map, str);
    }
}
