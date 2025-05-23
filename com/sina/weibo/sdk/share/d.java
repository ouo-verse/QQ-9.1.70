package com.sina.weibo.sdk.share;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.sina.weibo.sdk.api.VideoSourceObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class d extends AsyncTask<WeiboMultiMessage, Void, c> {
    private WeakReference<Context> I;
    private b J;

    public d(Context context, b bVar) {
        this.I = new WeakReference<>(context);
        this.J = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public c doInBackground(WeiboMultiMessage... weiboMultiMessageArr) {
        WeiboMultiMessage weiboMultiMessage;
        Uri uri;
        Context context = this.I.get();
        if (context == null || (weiboMultiMessage = weiboMultiMessageArr[0]) == null) {
            return null;
        }
        c cVar = new c();
        try {
            if (weiboMultiMessage.imageObject != null && weiboMultiMessage.multiImageObject != null) {
                weiboMultiMessage.imageObject = null;
            }
            if (weiboMultiMessage.videoSourceObject != null && (weiboMultiMessage.imageObject != null || weiboMultiMessage.multiImageObject != null)) {
                weiboMultiMessage.imageObject = null;
                weiboMultiMessage.multiImageObject = null;
            }
            if (weiboMultiMessage.multiImageObject != null) {
                ArrayList<Uri> arrayList = new ArrayList<>();
                Iterator<Uri> it = weiboMultiMessage.multiImageObject.getImageList().iterator();
                while (it.hasNext()) {
                    Uri next = it.next();
                    if (next != null && com.sina.weibo.sdk.c.b.a(context, next)) {
                        String a16 = a.a(context, next, 1);
                        if (!TextUtils.isEmpty(a16)) {
                            arrayList.add(Uri.fromFile(new File(a16)));
                        } else {
                            throw new IllegalArgumentException("image's path is null");
                        }
                    }
                }
                weiboMultiMessage.multiImageObject.imageList = arrayList;
            }
            VideoSourceObject videoSourceObject = weiboMultiMessage.videoSourceObject;
            if (videoSourceObject != null && (uri = videoSourceObject.videoPath) != null && com.sina.weibo.sdk.c.b.b(context, uri)) {
                String a17 = a.a(context, uri, 0);
                com.sina.weibo.sdk.c.c.a("WBShareTag", "prepare video resource and video'path is" + a17);
                if (!TextUtils.isEmpty(a17)) {
                    weiboMultiMessage.videoSourceObject.videoPath = Uri.fromFile(new File(a17));
                    VideoSourceObject videoSourceObject2 = weiboMultiMessage.videoSourceObject;
                    long j3 = 0;
                    if (!TextUtils.isEmpty(a17) && new File(a17).exists()) {
                        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                        mediaMetadataRetriever.setDataSource(a17);
                        j3 = Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
                    }
                    videoSourceObject2.during = j3;
                } else {
                    throw new IllegalArgumentException("video's path is null");
                }
            }
            cVar.G = weiboMultiMessage;
            cVar.F = true;
        } catch (Throwable th5) {
            cVar.F = false;
            String message = th5.getMessage();
            if (TextUtils.isEmpty(message)) {
                message = th5.toString();
            }
            cVar.errorMessage = message;
            com.sina.weibo.sdk.c.c.b("WBShareTag", "prepare resource error is :" + message);
        }
        return cVar;
    }

    @Override // android.os.AsyncTask
    protected final /* synthetic */ void onPostExecute(c cVar) {
        c cVar2 = cVar;
        super.onPostExecute(cVar2);
        b bVar = this.J;
        if (bVar != null) {
            bVar.a(cVar2);
        }
    }

    @Override // android.os.AsyncTask
    protected final void onPreExecute() {
        super.onPreExecute();
    }
}
