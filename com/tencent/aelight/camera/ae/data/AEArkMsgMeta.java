package com.tencent.aelight.camera.ae.data;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AEArkMsgMeta implements Serializable {
    public Inner meta;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class Inner implements Serializable {
        public int contentHeight;
        public String contentType;
        public String contentUrl;
        public int contentWidth;
        public String coverImageUrl;
        public String score;
        public String shareMsg;
        public String title;
        public String userImageUrl;
        public String widgetId;
    }
}
