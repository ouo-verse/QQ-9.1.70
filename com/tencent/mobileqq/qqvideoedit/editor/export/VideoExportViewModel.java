package com.tencent.mobileqq.qqvideoedit.editor.export;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Pair;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qqvideoedit.editor.VideoEditorViewModel;
import com.tencent.mobileqq.qqvideoedit.editor.aw;
import com.tencent.mobileqq.qqvideoedit.editor.draft.VideoEditData;
import com.tencent.mobileqq.qqvideoedit.editor.draft.VideoEditDataWrapper;
import com.tencent.mobileqq.qqvideoedit.editor.export.VideoExportViewModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.MediaClip;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.MediaModel;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.tavcut.composition.model.component.Size;
import com.tencent.tavcut.rendermodel.RenderModel;
import cooperation.peak.PeakConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import okio.ByteString;

/* compiled from: P */
/* loaded from: classes17.dex */
public class VideoExportViewModel extends BaseViewModel {

    /* renamed from: i, reason: collision with root package name */
    private MutableLiveData<c> f275724i = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name */
    private MutableLiveData<VideoExportProgress> f275725m = new MutableLiveData<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qqvideoedit.editor.export.VideoExportViewModel$1, reason: invalid class name */
    /* loaded from: classes17.dex */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ String C;
        final /* synthetic */ long D;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f275726d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ VideoEditDataWrapper f275727e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ MediaModel f275728f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ aw f275729h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ VideoEditData f275730i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ BasePartFragment f275731m;

        AnonymousClass1(int i3, VideoEditDataWrapper videoEditDataWrapper, MediaModel mediaModel, aw awVar, VideoEditData videoEditData, BasePartFragment basePartFragment, String str, long j3) {
            this.f275726d = i3;
            this.f275727e = videoEditDataWrapper;
            this.f275728f = mediaModel;
            this.f275729h = awVar;
            this.f275730i = videoEditData;
            this.f275731m = basePartFragment;
            this.C = str;
            this.D = j3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ int b(File file, File file2) {
            long lastModified = file.lastModified() - file2.lastModified();
            if (lastModified == 0) {
                return 0;
            }
            if (lastModified > 0) {
                return 1;
            }
            return -1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            try {
                boolean z16 = false;
                if (VideoExportViewModel.this.f275725m != null) {
                    VideoExportViewModel.this.f275725m.postValue(new VideoExportProgress(0, this.f275726d));
                }
                String missionId = this.f275727e.getMissionId();
                String str = lj2.a.f414865e;
                File file = new File(str);
                if (!file.exists()) {
                    file.mkdirs();
                } else {
                    File[] listFiles = file.listFiles();
                    if (listFiles != null && listFiles.length > 8) {
                        ArrayList arrayList = new ArrayList(Arrays.asList(listFiles));
                        Collections.sort(arrayList, new Comparator() { // from class: com.tencent.mobileqq.qqvideoedit.editor.export.d
                            @Override // java.util.Comparator
                            public final int compare(Object obj, Object obj2) {
                                int b16;
                                b16 = VideoExportViewModel.AnonymousClass1.b((File) obj, (File) obj2);
                                return b16;
                            }
                        });
                        for (int i3 = 0; i3 < arrayList.size() - 8; i3++) {
                            ((File) arrayList.get(i3)).delete();
                        }
                    }
                }
                File file2 = new File(this.f275728f.videos.get(0).resource.path);
                StringBuilder sb5 = new StringBuilder();
                sb5.append(str);
                String str2 = File.separator;
                sb5.append(str2);
                sb5.append("output_");
                sb5.append(missionId);
                sb5.append("_");
                sb5.append(System.currentTimeMillis());
                sb5.append("_");
                sb5.append(VideoExportViewModel.T1(file2.getName()));
                sb5.append(".jpg");
                String sb6 = sb5.toString();
                String str3 = str + str2 + "output_" + missionId + "_" + System.currentTimeMillis() + "_" + VideoExportViewModel.T1(file2.getName()) + ".mp4";
                Pair<Integer, Integer> i16 = a.i(this.f275727e);
                float intValue = ((Integer) i16.first).intValue();
                float intValue2 = ((Integer) i16.second).intValue();
                RenderModel renderModel = this.f275729h.l().getRenderModel();
                if (renderModel != null) {
                    try {
                        be4.b c16 = od4.b.f422509e.c(renderModel, new Size(Integer.valueOf((int) intValue), Integer.valueOf((int) intValue2), ByteString.EMPTY), VideoExportViewModel.N1(this.f275730i));
                        Bitmap coverAtTime = c16.getCoverAtTime(0L);
                        if (coverAtTime != null) {
                            z16 = FileUtils.saveBitmapToFile(coverAtTime, sb6);
                            coverAtTime.recycle();
                        }
                        c16.release();
                        ms.a.c("VideoExportViewModel", "startExport... extract cover isSuccess:" + z16 + " thumbfileName:" + sb6);
                    } catch (Exception e16) {
                        ms.a.d("VideoExportViewModel", "startExport ERROR", e16);
                    }
                }
                String stringExtra = this.f275731m.getActivity().getIntent().getStringExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID);
                if (z16) {
                    LocalMediaInfo O1 = VideoExportViewModel.this.O1(this.f275728f.videos, str3, sb6, missionId, (int) intValue, (int) intValue2, this.C);
                    O1.mMediaType = 1;
                    new ArrayList().add(O1.path);
                    new HashMap().put(O1.path, O1);
                    this.f275727e.setOutMediaInfo(O1);
                    wj2.a.c(this.f275727e, missionId);
                    a.g().o(this.f275727e, stringExtra, this.D, VideoExportViewModel.this.f275725m);
                    return;
                }
                if (VideoExportViewModel.this.f275725m != null && VideoExportViewModel.this.f275725m.getValue() != 0) {
                    VideoExportProgress videoExportProgress = (VideoExportProgress) VideoExportViewModel.this.f275725m.getValue();
                    videoExportProgress.j(3);
                    videoExportProgress.f("Save thumb file failed.");
                    VideoExportViewModel.this.f275725m.postValue(videoExportProgress);
                }
                ms.a.c("VideoExportViewModel", "Export error: Save thumb file failed.");
            } catch (Throwable th5) {
                if (VideoExportViewModel.this.f275725m != null && VideoExportViewModel.this.f275725m.getValue() != 0) {
                    VideoExportProgress videoExportProgress2 = (VideoExportProgress) VideoExportViewModel.this.f275725m.getValue();
                    videoExportProgress2.j(3);
                    videoExportProgress2.f(th5.toString());
                    VideoExportViewModel.this.f275725m.postValue(videoExportProgress2);
                }
                ms.a.c("VideoExportViewModel", "Export error:" + th5);
            }
        }
    }

    public static LocalMediaInfo M1(ArrayList<String> arrayList, @NonNull String str, int i3, int i16, @NonNull String str2, @Nullable String str3, @NonNull String str4, @NonNull String str5) {
        LocalMediaInfo localMediaInfo = new LocalMediaInfo();
        localMediaInfo.thumbHeight = i3;
        localMediaInfo.thumbWidth = i16;
        localMediaInfo.path = str2;
        localMediaInfo.mediaHeight = i3;
        localMediaInfo.mediaWidth = i16;
        localMediaInfo.mMimeType = "video/mp4";
        localMediaInfo.addedDate = System.currentTimeMillis();
        localMediaInfo.modifiedDate = System.currentTimeMillis();
        localMediaInfo.thumbnailPath = str3;
        localMediaInfo.mDuration = 0L;
        localMediaInfo.isSystemMeidaStore = false;
        localMediaInfo.isMakeVideo = false;
        localMediaInfo.isVideoReady = false;
        localMediaInfo.missionID = str4;
        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add(str5);
        localMediaInfo.mHashTagList = arrayList2;
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        localMediaInfo.mOriginPath = arrayList;
        ms.a.a("VideoExportViewModel", "buildLocalMediaInfoForNotReady: info = " + localMediaInfo.toString());
        return localMediaInfo;
    }

    public static List<fe4.a> N1(VideoEditData videoEditData) {
        if (videoEditData != null && videoEditData.getOpenHDR()) {
            com.tencent.mobileqq.qqvideoedit.editor.hdr.a aVar = new com.tencent.mobileqq.qqvideoedit.editor.hdr.a();
            aVar.l();
            aVar.m(true);
            ArrayList arrayList = new ArrayList();
            arrayList.add(aVar);
            ms.a.f("VideoExportViewModel", "createExtraEffectNode:open HDR.");
            return arrayList;
        }
        return null;
    }

    private void Q1(BasePartFragment basePartFragment, aw awVar, VideoEditDataWrapper videoEditDataWrapper, String str, long j3, int i3) {
        ArrayList<VideoEditData> editData = videoEditDataWrapper.getEditData();
        if (editData != null && editData.size() == 1) {
            VideoEditData videoEditData = editData.get(0);
            if (videoEditData == null) {
                ms.a.c("VideoExportViewModel", "exportVideo... error videoEditData == null");
                return;
            }
            MediaModel mediaModel = videoEditData.getMediaModel();
            if (mediaModel == null) {
                ms.a.c("VideoExportViewModel", "exportVideo... error mediaModel == null");
                return;
            } else {
                ThreadManager.getFileThreadHandler().post(new AnonymousClass1(i3, videoEditDataWrapper, mediaModel, awVar, videoEditData, basePartFragment, str, j3));
                return;
            }
        }
        ms.a.c("VideoExportViewModel", "exportVideo... list.size error");
    }

    public static String R1() {
        return "multi_video_" + System.currentTimeMillis();
    }

    public static String T1(String str) {
        if (str != null && !str.equals("")) {
            int lastIndexOf = str.lastIndexOf(".");
            int lastIndexOf2 = str.lastIndexOf(File.separator);
            if (lastIndexOf2 == -1) {
                if (lastIndexOf != -1) {
                    return str.substring(0, lastIndexOf);
                }
                return str;
            }
            if (lastIndexOf == -1) {
                return str.substring(lastIndexOf2 + 1);
            }
            if (lastIndexOf2 < lastIndexOf) {
                return str.substring(lastIndexOf2 + 1, lastIndexOf);
            }
            return str.substring(lastIndexOf2 + 1);
        }
        return str;
    }

    protected LocalMediaInfo O1(List<MediaClip> list, String str, String str2, String str3, int i3, int i16, String str4) {
        ArrayList arrayList = new ArrayList();
        for (int i17 = 0; i17 < list.size(); i17++) {
            arrayList.add(list.get(i17).resource.path);
        }
        ms.a.f("VideoExportViewModel", "createLocalMediaInfo... originPathList:" + arrayList);
        return M1(arrayList, "", i3, i16, str, str2, str3, str4);
    }

    public MutableLiveData<c> S1() {
        return this.f275724i;
    }

    public MutableLiveData<VideoExportProgress> U1() {
        return this.f275725m;
    }

    public void W1(BasePartFragment basePartFragment, aw awVar, VideoEditDataWrapper videoEditDataWrapper, String str, long j3, int i3) {
        ms.a.c("VideoExportViewModel", "startExport...");
        VideoEditorViewModel videoEditorViewModel = (VideoEditorViewModel) basePartFragment.getViewModel(VideoEditorViewModel.class);
        if (videoEditorViewModel == null) {
            ms.a.c("VideoExportViewModel", "startExport... error videoEditorViewModel == null");
            return;
        }
        if (videoEditDataWrapper == null) {
            ms.a.c("VideoExportViewModel", "startExport... error dataWrapper == null");
        } else if (videoEditDataWrapper.getEditMode().intValue() == 0) {
            Q1(basePartFragment, awVar, videoEditDataWrapper, str, j3, i3);
        } else if (videoEditDataWrapper.getEditMode().intValue() == 1) {
            P1(basePartFragment, videoEditorViewModel, awVar, videoEditDataWrapper);
        }
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "VideoExportViewModel";
    }

    private void P1(BasePartFragment basePartFragment, VideoEditorViewModel videoEditorViewModel, aw awVar, VideoEditDataWrapper videoEditDataWrapper) {
    }
}
