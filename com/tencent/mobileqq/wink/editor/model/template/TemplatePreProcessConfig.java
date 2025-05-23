package com.tencent.mobileqq.wink.editor.model.template;

import java.util.List;

/* loaded from: classes21.dex */
public class TemplatePreProcessConfig {
    public static final int MEDIA_INDEX_NOT_USED = -1;
    private boolean imageOnly;
    private List<Media> medias;
    private boolean needFaceDetect;
    private boolean needUserInfo;
    private int segmentCount;
    private int version;

    /* loaded from: classes21.dex */
    public static class Media {
        private int duration;
        private int fillMode;
        private int height;
        private int index;
        private int maxSize;
        private List<Preprocess> preprocess;
        private float volume;
        private int width;

        /* loaded from: classes21.dex */
        public static class Preprocess {
            private int duration;
            private int fillMode;
            private int height;
            private int index;
            private List<Integer> multipleIndexes;
            private RequestParams requestParams;
            private float videoFrameTimeProportion = 1.0f;
            private float volume;
            private int width;

            /* loaded from: classes21.dex */
            public static class RequestParams {
                private String busiID;
                private String extra;

                public String getBusiID() {
                    return this.busiID;
                }

                public String getExtra() {
                    return this.extra;
                }

                public void setBusiID(String str) {
                    this.busiID = str;
                }

                public void setExtra(String str) {
                    this.extra = str;
                }
            }

            public int getDuration() {
                return this.duration;
            }

            public int getFillMode() {
                return this.fillMode;
            }

            public int getHeight() {
                return this.height;
            }

            public int getIndex() {
                return this.index;
            }

            public List<Integer> getMultipleIndexes() {
                return this.multipleIndexes;
            }

            public RequestParams getRequestParams() {
                return this.requestParams;
            }

            public float getVideoFrameTimeProportion() {
                return this.videoFrameTimeProportion;
            }

            public float getVolume() {
                return this.volume;
            }

            public int getWidth() {
                return this.width;
            }

            public void setDuration(int i3) {
                this.duration = i3;
            }

            public void setFillMode(int i3) {
                this.fillMode = i3;
            }

            public void setHeight(int i3) {
                this.height = i3;
            }

            public void setIndex(int i3) {
                this.index = i3;
            }

            public void setMultipleIndexes(List<Integer> list) {
                this.multipleIndexes = list;
            }

            public void setRequestParams(RequestParams requestParams) {
                this.requestParams = requestParams;
            }

            public void setVideoFrameTimeProportion(float f16) {
                this.videoFrameTimeProportion = f16;
            }

            public void setVolume(float f16) {
                this.volume = f16;
            }

            public void setWidth(int i3) {
                this.width = i3;
            }
        }

        public int getDuration() {
            return this.duration;
        }

        public int getFillMode() {
            return this.fillMode;
        }

        public int getHeight() {
            return this.height;
        }

        public int getIndex() {
            return this.index;
        }

        public int getMaxSize() {
            return this.maxSize;
        }

        public List<Preprocess> getPreprocess() {
            return this.preprocess;
        }

        public float getVolume() {
            return this.volume;
        }

        public int getWidth() {
            return this.width;
        }

        public void setDuration(int i3) {
            this.duration = i3;
        }

        public void setFillMode(int i3) {
            this.fillMode = i3;
        }

        public void setHeight(int i3) {
            this.height = i3;
        }

        public void setIndex(int i3) {
            this.index = i3;
        }

        public void setMaxSize(int i3) {
            this.maxSize = i3;
        }

        public void setPreprocess(List<Preprocess> list) {
            this.preprocess = list;
        }

        public void setVolume(float f16) {
            this.volume = f16;
        }

        public void setWidth(int i3) {
            this.width = i3;
        }
    }

    public boolean getImageOnly() {
        return this.imageOnly;
    }

    public List<Media> getMedias() {
        return this.medias;
    }

    public int getSegmentCount() {
        return this.segmentCount;
    }

    public int getVersion() {
        return this.version;
    }

    public boolean isNeedFaceDetect() {
        return this.needFaceDetect;
    }

    public boolean isNeedUserInfo() {
        return this.needUserInfo;
    }

    public void setImageOnly(boolean z16) {
        this.imageOnly = z16;
    }

    public void setMedias(List<Media> list) {
        this.medias = list;
    }

    public void setNeedFaceDetect(boolean z16) {
        this.needFaceDetect = z16;
    }

    public void setNeedUserInfo(boolean z16) {
        this.needUserInfo = z16;
    }

    public void setSegmentCount(int i3) {
        this.segmentCount = i3;
    }

    public void setVersion(int i3) {
        this.version = i3;
    }
}
