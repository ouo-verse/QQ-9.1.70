package com.sina.weibo.sdk.share;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.sina.weibo.sdk.api.StoryMessage;
import com.sina.weibo.sdk.api.StoryObject;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class e extends AsyncTask<StoryMessage, Void, c> {
    private WeakReference<Context> I;
    private b J;

    public e(Context context, b bVar) {
        this.I = new WeakReference<>(context);
        this.J = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public c doInBackground(StoryMessage... storyMessageArr) {
        StoryMessage storyMessage;
        Context context = this.I.get();
        if (context == null || (storyMessage = storyMessageArr[0]) == null) {
            return null;
        }
        c cVar = new c();
        try {
            Uri imageUri = storyMessage.getImageUri();
            if (imageUri != null && com.sina.weibo.sdk.c.b.a(context, imageUri)) {
                cVar.H = b(context, imageUri, 1);
                cVar.F = true;
            }
            Uri videoUri = storyMessage.getVideoUri();
            if (videoUri != null && com.sina.weibo.sdk.c.b.b(context, videoUri)) {
                cVar.H = b(context, videoUri, 0);
                cVar.F = true;
            }
        } catch (Throwable th5) {
            cVar.F = false;
            cVar.errorMessage = th5.getMessage();
        }
        return cVar;
    }

    private static StoryObject b(Context context, Uri uri, int i3) {
        String a16 = a.a(context, uri, i3);
        if (TextUtils.isEmpty(a16)) {
            return null;
        }
        StoryObject storyObject = new StoryObject();
        storyObject.sourcePath = a16;
        storyObject.sourceType = i3;
        storyObject.appId = com.sina.weibo.sdk.a.a().getAppKey();
        storyObject.appPackage = context.getPackageName();
        storyObject.callbackAction = "com.sina.weibo.sdk.action.ACTION_SDK_REQ_STORY";
        return storyObject;
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
}
